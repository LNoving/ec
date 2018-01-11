package com.ec.demo.web;

import com.ec.demo.cons.CommonConstant;
import com.ec.demo.dao.LoginLogRepository;
import com.ec.demo.domain.LoginLog;
import com.ec.demo.domain.User;
import com.ec.demo.service.UserServiceImpl;
import com.ec.demo.service.interfaces.UserService;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.spi.LoggerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author 张昊
 */
@Controller
public class LoginController extends BaseController{

    @Resource
    private UserService userService = new UserServiceImpl();

    @RequestMapping("/login")
    public String login(HttpServletRequest request){
        if(null!=getSessionUser(request)){
            return "redirect:/user/information";
        }
        return "login";
    }

    @PostMapping("/doLogin")
    public ModelAndView loginCheck(HttpServletRequest request,User user){

        User dbUser = userService.findUserByName(user.getUserName());
        ModelAndView mav = new ModelAndView();
        mav.setViewName("forward:/login");
        if(null!=getSessionUser(request)){
            mav.setViewName("redirect:/user/information");
            return mav;
        }
        if (dbUser == null) {
            mav.addObject("errorMsg", "用户名不存在!");
        } else if (!dbUser.getPassword().equals(user.getPassword())) {
            mav.addObject("errorMsg", "用户密码不正确!");
        } else if (userService.isOnline(dbUser)){
            mav.addObject("errorMsg","用户已在线！");
        }
        else {
            setSessionUser(request,dbUser, userService.loginSuccess(dbUser));
            String toUrl = (String)request.getSession().getAttribute(CommonConstant.LOGIN_TO_URL);
            request.getSession().removeAttribute(CommonConstant.LOGIN_TO_URL);
            if(StringUtils.isEmpty(toUrl)){
                toUrl = "/index.html";
            }
            mav.setViewName("redirect:"+toUrl);
        }
        return mav;
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request) {
        userService.logoutSuccess((LoginLog) request.getSession().getAttribute(CommonConstant.USER_LOGINLOG));
        request.getSession().removeAttribute(CommonConstant.USER_CONTEXT);
        request.getSession().removeAttribute(CommonConstant.USER_LOGINLOG);
        return "redirect:/index.html";
    }

}
