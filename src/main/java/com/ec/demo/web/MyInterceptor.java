package com.ec.demo.web;

import com.ec.demo.domain.User;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.ec.demo.cons.CommonConstant.LOGIN_TO_URL;

/**
 * @author .
 */
public class MyInterceptor extends BaseController implements HandlerInterceptor{


    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,Object handler)throws Exception{
        boolean flag;
        User user = getSessionUser(request);

        if (null == user){

            String toUrl = request.getRequestURL().toString();
            if (!StringUtils.isEmpty(request.getQueryString())) {
                toUrl += "?" + request.getQueryString();
            }
            request.getSession().setAttribute(LOGIN_TO_URL,toUrl);
            response.sendRedirect("/login");
            flag = false;

        }else {
            flag = true;
        }
        return flag;

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object handler, ModelAndView modelAndView)throws Exception{
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler, Exception ex) throws Exception {
    }



}
