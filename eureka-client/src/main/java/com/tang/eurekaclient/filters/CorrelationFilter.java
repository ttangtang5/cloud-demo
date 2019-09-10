package com.tang.eurekaclient.filters;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @Description 获取zuul中的关联id
 * @Author RLY
 * @Date 2019/6/26 17:02
 * @Version 1.0
 **/
@Component
public class CorrelationFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;

        UserContextHolder.getUserContext()
                .setCorrelationId(request.getHeader(UserContextHolder.CORRELATION_ID));

        UserContextHolder.getUserContext()
                .setToken(request.getHeader(UserContextHolder.TOKEN));

        filterChain.doFilter(request, servletResponse);

        System.out.println("111111");
        UserContextHolder.remove();
    }

    @Override
    public void destroy() {

    }
}
