<%--
  Created by IntelliJ IDEA.
  User: LeeB
  Date: 2023/3/8
  Time: 13:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h1>当前有<span style="color: aquamarine"><%=this.getServletConfig().getServletContext().getAttribute("OnlineCount")%></span> 人在线</h1>
  </body>
</html>
