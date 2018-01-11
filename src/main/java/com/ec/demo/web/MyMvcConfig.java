package com.ec.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

import java.util.EventListener;

/**
 * @author .
 */
@EnableWebMvc
@Configuration
public class MyMvcConfig extends WebMvcConfigurerAdapter {


    private static final String[] INHERENT_URIS = {
            "/commodities","/user/information","/sell","/doSell","/purchase",
            "/commodity","/commodity/**",
            "/demands","/demands/**","/postDemand","/doDemand"
    };


    /**
     * 拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // addPathPatterns 用于添加拦截规则
        // excludePathPatterns 用户排除拦截
        registry.addInterceptor(new MyInterceptor()).addPathPatterns(INHERENT_URIS);
        super.addInterceptors(registry);

    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
        super.addResourceHandlers(registry);
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/index.html").setViewName("index");
        registry.addViewController("/").setViewName("index");
        super.addViewControllers(registry);
    }

}
