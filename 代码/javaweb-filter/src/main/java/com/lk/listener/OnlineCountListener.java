package com.lk.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

//统计网站在线人数，统计session
public class OnlineCountListener implements HttpSessionListener {
//    创建session监听
    //一旦创建一个session 就会触发一次这个事件
    public void sessionCreated(HttpSessionEvent se) {
        ServletContext ctx = se.getSession().getServletContext();
        System.out.println(se.getSession().getId());
        Integer onlineCount = (Integer) ctx.getAttribute("OnlineCount");

        if (onlineCount == null){
            onlineCount = new Integer(1);
        }else {
            int count = onlineCount.intValue();
            onlineCount = new Integer(count + 1);
        }

        ctx.setAttribute("OnlineCount",onlineCount);
    }
//销毁session监听
    //一旦销毁session就会触发一次这个事件
    public void sessionDestroyed(HttpSessionEvent se) {
        ServletContext ctx = se.getSession().getServletContext();
        se.getSession().invalidate(); //手动销毁session
        Integer onlineCount = (Integer) ctx.getAttribute("OnlineCount");

        if (onlineCount == null){
            onlineCount = new Integer(0);
        }else {
            int count = onlineCount.intValue();
            onlineCount = new Integer(count - 1);
        }

        ctx.setAttribute("OnlineCount",onlineCount);
    }
}
