<%--
  Created by IntelliJ IDEA.
  User: LeeB
  Date: 2023/2/23
  Time: 16:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
  <title>Title</title>
</head>
<body>
<%-- <%@include 会将两个页面合二为一 --%>
<%@include file="common/header.jsp"%>
<h1>网页主体</h1>

<%@include file="common/footer.jsp"%>

<hr>

<%--JSP标签
jsp:include 拼接页面，本质还是3个
--%>
  <jsp:include page="/common/header.jsp"/>
  <h1>网页主体</h1>
  <%
  int i = 10 ;
  %>
  <jsp:include page="/common/footer.jsp"/>
</body>
</html>
