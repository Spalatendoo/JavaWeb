<%--
  Created by IntelliJ IDEA.
  User: LeeB
  Date: 2023/2/23
  Time: 21:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
  pageContext.forward("/index.jsp");
  //Servlet后台代码形式
    // request.getRequestDispatcher("/index.jsp").forward(request,response);
%>
</body>
</html>
