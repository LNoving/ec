package com.ec.demo.service.interfaces;

import com.ec.demo.domain.LoginLog;
import com.ec.demo.domain.User;
import com.ec.demo.exception.UserExistException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;


public interface UserService {

    User findUserByName(String name);

    void save(User user);

    void delete(User user);

    void register(User user)throws UserExistException;

    LoginLog loginSuccess(User user);

    void logoutSuccess(LoginLog loginLog);

    boolean isOnline(User user);

}
