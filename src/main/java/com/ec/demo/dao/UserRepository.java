package com.ec.demo.dao;

import com.ec.demo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author 张昊
 */
@Repository
public interface UserRepository extends JpaRepository <User,Integer>{


    /**
     * 接口方法
     * @param userName
     * @return
     */
    User findUserByUserName(String userName);


}
