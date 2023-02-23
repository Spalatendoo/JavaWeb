<%--
  Created by IntelliJ IDEA.
  User: LeeB
  Date: 2023/2/23
  Time: 15:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%--定制错误页面--%>
<%--显式的声明这是一个错误页面--%>
<%@page isErrorPage="true" %>
<%--<%@ page errorPage="error/500.jsp" %>--%>
<head>
    <title>Title</title>
</head>
<body>
<%
  int x = 1/0;
%>
</body>
</html>
