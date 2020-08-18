package com.qy.interceltor;


import com.qy.model.Link;
import com.qy.service.impl.LinkServiceImpl;
import com.qy.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

/**
 * @author qiuyang
 * @date 2020/8/18
 */
@Component
@WebFilter("/**")
public class MyFilter implements Filter {
    //排除不拦截的url
    private static final String[] excludePathPatterns = {"/index.html","/link.html","/404.html","/list","/delete"
            ,"/getShortUrl","/js/jquery.min.js"};

    @Autowired
    private LinkServiceImpl linkService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;

        // 获取请求url地址，不拦截excludePathPatterns中的url
        if (Arrays.asList(excludePathPatterns).contains(request.getRequestURI())) {
            //放行，相当于第一种方法中LoginInterceptor返回值为true
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        StringBuffer url = request.getRequestURL();
        Link link = linkService.findByShortUrl(url.toString());
        if (link == null){
            response.sendRedirect("http://127.0.0.1/404.html");
            return;
        }
        long timeSub = DateUtil.getTimeSub(link.getCreateTime(), new Date());
        if (timeSub > 1){
            response.sendRedirect("http://127.0.0.1/404.html");
            return;
        }
        response.sendRedirect(link.getLongUrl());
    }

    @Override
    public void destroy() {

    }
}
