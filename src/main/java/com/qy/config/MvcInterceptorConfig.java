package com.qy.config;

import com.qy.interceltor.MyIntercelter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author qiuyang
 * @date 2020/8/18
 */
//@Configuration
public class MvcInterceptorConfig extends WebMvcConfigurationSupport {

    @Autowired
    private MyIntercelter myIntercelter;

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        // 多个拦截器组成一个拦截器链
        // addPathPatterns 用于添加拦截规则，/**表示拦截所有请求
        // excludePathPatterns 用户排除拦截
        registry.addInterceptor(myIntercelter).addPathPatterns("/**")
                .excludePathPatterns("/index.html","/getShortUrl");
        super.addInterceptors(registry);
    }
}
