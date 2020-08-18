package com.qy.interceltor;

import com.qy.service.impl.LinkServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author qiuyang
 * @date 2020/8/18
 */
@Component
public class MyIntercelter implements HandlerInterceptor {

    @Autowired
    private LinkServiceImpl linkService;

    /**
     * 预处理回调方法，实现处理器的预处理
     * 返回值：true表示继续流程；false表示流程中断，不会继续调用其他的拦截器或处理器
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        System.out.println("开始拦截........." + request.getRequestURL());
        //业务代码
        return true;
    }
}
