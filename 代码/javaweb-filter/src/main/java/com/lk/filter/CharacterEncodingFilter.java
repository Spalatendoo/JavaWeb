package com.kuang.filter;

import javax.servlet.*;
import java.io.IOException;

public class CharacterEncodingFilter implements Filter {
    //初始化
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("CharacterEncodingFilter初始化");
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)throws IOException,ServletException {

    }
    //销毁
    public void destroy(){
        System.out.println("CharacterEncodingFilter销毁");
    }
}
