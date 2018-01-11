package com.ec.demo.service;

import com.ec.demo.dao.LoginLogRepository;
import com.ec.demo.dao.UserRepository;
import com.ec.demo.domain.LoginLog;
import com.ec.demo.domain.User;
import com.ec.demo.exception.UserExistException;
import com.ec.demo.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author 张昊
 */
@EnableTransactionManagement
@Service
public class UserServiceImpl implements UserService {


    private UserRepository userRepository;

    private LoginLogRepository loginLogRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Autowired
    public void setLoginLogRepository(LoginLogRepository loginLogRepository){
        this.loginLogRepository = loginLogRepository;
    }

    @Override
    public User findUserByName(String userName){
        return userRepository.findUserByUserName(userName);
    }

    @Override
    public void save(User user){
        userRepository.save(user);
    }

    @Override
    public void delete(User user){
        userRepository.delete(user);
    }

    @Override
    public void register(User user)throws UserExistException{
        User user1 = this.findUserByName(user.getUserName());
        if (user1 != null){
            throw new UserExistException("用户名已存在！");
        }
        else{
            user.setCreateDate(new Date());
            userRepository.save(user);
        }
    }

    @Override
    public LoginLog loginSuccess(User user) {
        LoginLog loginLog = new LoginLog();
        loginLog.setUser(user);
        loginLog.setLastLogin(new Date());
        //暂未实现
        loginLog.setLastLogout(new Date());
        loginLogRepository.save(loginLog);
        return loginLog;
    }

    @Override
    public void logoutSuccess(LoginLog loginLog){
        loginLog.setLastLogout(new Date());
        loginLogRepository.save(loginLog);
    }

    @Override
    public boolean isOnline(User user){
        List<LoginLog> list = loginLogRepository.findAllByUser(user);
        return !list.isEmpty()&&list.get(list.size() -1).getLastLogout()==null;
    }

}
