package com.lk.filter;

import com.lk.util.Constant;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SysFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // ServletRequest  HttpServletRequest
        HttpServletRequest request1 = (HttpServletRequest) servletRequest;
        HttpServletResponse response1 = (HttpServletResponse) servletResponse;

        Object user_session = request1.getSession().getAttribute(Constant.USER_SESSION);
        if (user_session == null){
            response1.sendRedirect("/error.jsp");
        }

        filterChain.doFilter(servletRequest,servletResponse);

    }

    @Override
    public void destroy() {

    }
}
