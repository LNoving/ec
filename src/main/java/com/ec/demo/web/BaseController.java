package com.ec.demo.web;

import com.ec.demo.cons.CommonConstant;
import com.ec.demo.domain.LoginLog;
import com.ec.demo.domain.User;
import org.springframework.util.Assert;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 张昊
 */
public class BaseController extends WebMvcConfigurerAdapter{

    protected static final String ERROR_MSG_KEY = "errorMsg";



    /**
     * 获取保存在Session中的用户对象
     * @param request
     * @return
     */
    protected User getSessionUser(HttpServletRequest request) {
        return (User) request.getSession().getAttribute(
                CommonConstant.USER_CONTEXT);
    }

    /**
     * 保存用户对象到Session中
     * @param request
     * @param user
     */
    protected void setSessionUser(HttpServletRequest request, User user, LoginLog loginLog) {
        request.getSession().setAttribute(CommonConstant.USER_CONTEXT,
                user);
        request.getSession().setAttribute(CommonConstant.USER_LOGINLOG,loginLog);
    }


    /**
     * 获取基于应用程序的url绝对路径
     *
     * @param request
     * @param url
     *            以"/"打头的URL地址
     * @return 基于应用程序的url绝对路径
     */
    public final String getAppbaseUrl(HttpServletRequest request, String url) {
        Assert.hasLength(url, "url不能为空");
        Assert.isTrue(url.startsWith("/"), "必须以/打头");
        return request.getContextPath() + url;
    }



}
