package com.ec.demo.web;

import com.ec.demo.domain.User;
import com.ec.demo.exception.UserExistException;
import com.ec.demo.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 张昊
 */
@Controller
public class RegisterController extends BaseController {

    private UserServiceImpl userServiceImpl;

    @Autowired
    public void setUserServiceImpl(UserServiceImpl userServiceImpl){
        this.userServiceImpl = userServiceImpl;
    }

    @RequestMapping("/register")
    public String register(){
        return "register";
    }

    @PostMapping("/doRegister")
    public ModelAndView doRegister(HttpServletRequest request,User user){
        ModelAndView view = new ModelAndView();
        view.setViewName("redirect:/index.html");
        System.out.println(user.getUserName()+user.getPassword());
        try{
            userServiceImpl.register(user);
        }catch (UserExistException e){
            view.addObject("errorMsg", "用户名已经存在，请选择其它的名字。");
            view.setViewName("forward:/register");
        }
        setSessionUser(request,user,userServiceImpl.loginSuccess(user));
        return view;
    }

}
