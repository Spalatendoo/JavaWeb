<%--
  Created by IntelliJ IDEA.
  User: LeeB
  Date: 2023/3/7
  Time: 11:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>1</h1>
<%--jsp:include page=""--%>
<jsp:forward page="/jsptag2.jsp">
    <jsp:param name="name" value="zhangxiaonan"/>
    <jsp:param name="age" value="12"/>
</jsp:forward>

</body>
</html>
