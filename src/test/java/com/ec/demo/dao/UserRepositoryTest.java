package com.ec.demo.dao;

import com.ec.demo.domain.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Before
    public void initData(){
        userRepository.deleteAll();

        User user = new User();
        user.setUserName("abc");
        user.setCreateDate(new Date());
        user.setPassword("123");
        user.setUserType(1);


        userRepository.save(user);
    }
    @Test
    public void userTest(){
        initData();
    }
}
