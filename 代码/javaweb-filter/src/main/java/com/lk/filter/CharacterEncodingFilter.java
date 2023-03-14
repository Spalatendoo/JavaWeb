package com.lk.filter;

import javax.servlet.*;
import java.io.IOException;

public class CharacterEncodingFilter implements Filter {
    //初始化  web服务器启动就已经初始化了
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("CharacterEncodingFilter初始化");
    }


    /*
    过滤器中的所有代码，在过滤特定请求的时候都会执行
    必须要让过滤器继续执行   chain.doFilter(request,response);
    *
    *
    */
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)throws IOException,ServletException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");

        System.out.println("CharacterEncodingFilter 执行前...");
        chain.doFilter(request,response);  //让我们的请求继续走，如果不写，程序到这里就被拦截停止
        System.out.println("CharacterEncodingFilter 执行后...");
    }
    //销毁
    public void destroy(){
        System.out.println("CharacterEncodingFilter销毁");
    }
}
