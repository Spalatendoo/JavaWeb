<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: LeeB
  Date: 2023/3/7
  Time: 16:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
  ArrayList<String> people = new ArrayList<>();
  people.add(0,"zhangsan");
  people.add(1,"wangwu");
  people.add(2,"lisi");
  people.add(3,"zhaoqi");
  request.setAttribute("list",people);
%>

<%--
var ，每一次遍历出来的变量
items ， 要遍历的对象
begin , 哪里开始
end , 到哪里
step , 步长
--%>
<c:forEach var="people" items="${list}">
  <c:out value="${people}"/><br>
</c:forEach>

<hr>
<c:forEach begin="1" end="3" step="2" var="people" items="${list}">
  <c:out value="${people}"></c:out>
</c:forEach>
</body>
</html>
