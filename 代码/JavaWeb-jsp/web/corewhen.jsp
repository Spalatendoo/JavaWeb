<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: LeeB
  Date: 2023/3/7
  Time: 16:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--定义一个变量score，值为85--%>
<c:set var="score" value="85"/>
<c:choose>
  <c:when test="${score >=90}">
    你的成绩为优秀
  </c:when>
  <c:when test="${score >= 80}">
    你的成绩还不错
  </c:when>
</c:choose>
</body>
</html>
