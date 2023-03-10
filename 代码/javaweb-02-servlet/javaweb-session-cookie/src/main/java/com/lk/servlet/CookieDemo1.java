package com.lk.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

//保存用户上一次访问的时间
public class CookieDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //服务器，告诉你，你来的时间，把这个时间封装成为一个信件，下次来就知道了

        resp.setHeader("Content-type", "text/html;charset=UTF-8");

        //解决中文乱码
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");

        PrintWriter out = resp.getWriter();
        //Cookie,服务器端从客户端获取
        Cookie[] cookies = req.getCookies();  //这里返回数组，说明cookie可能存在多个

        // 判断cookie是否存在
        if (cookies!=null){
            //如果存在怎么办
            out.write("上次访问的时间是：");
/*            for (Cookie cookie : cookies) {
                
            }*/
            for (int i = 0; i < cookies.length; i++) {
                Cookie cookie = cookies[i];
                //获取cookie名字
                if (cookie.getName().equals("lastLoginTime")){
                    //获取cookie中的值
                    cookie.getValue();
                    long lastLoginTime = Long.parseLong(cookie.getValue());
                    Date date = new Date(lastLoginTime);
                    out.write(date.toLocaleString());

                }
            }

        }else {
            out.write("这是第一次访问");
        }

        //服务器给客户端响应cookie
        Cookie cookie = new Cookie("lastLoginTime", System.currentTimeMillis() + "");
        //cookie有效期为一天
        cookie.setMaxAge(24*60*60);
        resp.addCookie(cookie);

    }


}
