<%--
  Created by IntelliJ IDEA.
  User: LeeB
  Date: 2023/2/23
  Time: 20:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--
//scope 作用域
    public static final int PAGE_SCOPE = 1;
    public static final int REQUEST_SCOPE = 2;
    public static final int SESSION_SCOPE = 3;
    public static final int APPLICATION_SCOPE = 4;

    public void setAttribute(String name, Object attribute, int scope) {
        switch (scope) {
            case 1:
                this.mPage.put(name, attribute);
                break;
            case 2:
                this.mRequest.put(name, attribute);
                break;
            case 3:
                this.mSession.put(name, attribute);
                break;
            case 4:
                this.mApp.put(name, attribute);
                break;
            default:
                throw new IllegalArgumentException("Bad scope " + scope);
        }

    }
--%>
<%--
<%
  pageContext.setAttribute("hello1","hello1",PageContext.SESSION_SCOPE);
  //session.setAttribute("hello1","hello1")
    pageContext.setAttribute("hello1","hello1",PageContext.PAGE_SCOPE);
    //pageContext.setAttribute("name1","胡晓飞1");
    pageContext.setAttribute("hello1","hello1",PageContext.REQUEST_SCOPE);
    //request.setAttribute("name2","胡晓飞2");
    pageContext.setAttribute("hello1","hello1",PageContext.APPLICATION_SCOPE);
    //application.setAttribute("name4","胡晓飞4");
%>
--%>
</body>
</html>
