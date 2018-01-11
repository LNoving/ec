package com.ec.demo.web;

import com.ec.demo.cons.CommonConstant;
import com.ec.demo.domain.LoginLog;
import com.ec.demo.service.UserServiceImpl;
import com.ec.demo.service.interfaces.UserService;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @author .
 */
@WebListener
public class MySessionListener implements HttpSessionListener {

    private UserService userService = new UserServiceImpl();

    @Override
    public void sessionCreated(HttpSessionEvent se){
        System.out.println("用户Session");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se){
        System.out.println("用户Session退出");
        userService.logoutSuccess((LoginLog) se.getSession().getAttribute(CommonConstant.USER_LOGINLOG));
    }

}
