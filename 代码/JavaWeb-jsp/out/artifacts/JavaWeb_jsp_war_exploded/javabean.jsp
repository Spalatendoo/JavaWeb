<%@ page import="com.lk.pojo.People" %><%--
  Created by IntelliJ IDEA.
  User: LeeB
  Date: 2023/3/7
  Time: 19:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
//    People people = new People();
//    people.setAddress("西安");
//    people.setId(1);
//    people.setAge(24);
//    people.setName("huxiaofei");
    
  
%>
<jsp:useBean id="people" class="com.lk.pojo.People" scope="page"/>
<jsp:setProperty name="people" property="address" value="西安"/>
<jsp:setProperty name="people" property="id" value="1"/>
<jsp:setProperty name="people" property="age" value="24"/>
<jsp:setProperty name="people" property="name" value="huxiaofei"/>

姓名：<jsp:getProperty name="people" property="name"/> <br>
id：<jsp:getProperty name="people" property="id"/>  <br>
年龄：<jsp:getProperty name="people" property="age"/> <br>
地址：<jsp:getProperty name="people" property="address"/>
</body>
</html>
