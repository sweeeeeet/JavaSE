<%--
  Created by IntelliJ IDEA.
  User: 11583
  Date: 2019/5/24
  Time: 13:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>include指令</title>
</head>
<body>
引入文件(使用内部路径静态引入)</br>
<%@include file="demo2.jsp" %>
<%@include file="demo3.jsp" %>

<%!
    String s = "232";

    int add1(int a, int b) {
        return a + b;
    }

%>
<%
    out.println(s);
    out.print(add1(1,3));
%>

<%--JSP表达式--%>
add=<%=add1(1,3)%>
</body>
</html>
