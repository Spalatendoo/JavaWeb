<%--
  Created by IntelliJ IDEA.
  User: LeeB
  Date: 2023/2/23
  Time: 20:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<%--脚本片段中的代码，会被原封不动的生成到jsp.java
这里的代码 必须要保证java语法的正确性
--%>
<%
  //从pageContext取出，我们通过寻找的方式来
  String name1 = (String) pageContext.findAttribute("name1");
  String name2 = (String) pageContext.findAttribute("name2");
  String name3 = (String) pageContext.findAttribute("name3");
  String name4 = (String) pageContext.findAttribute("name4");
  String name5 = (String) pageContext.findAttribute("name5");
%>
<%--使用EL表达式输出  ${ } --%>
<h1>取出的值为</h1>
<h3>${name1}</h3>
<h3>${name2}</h3>
<h3>${name3}</h3>
<h3>${name4}</h3>
<h3>${name5}</h3>
</body>
</html>
