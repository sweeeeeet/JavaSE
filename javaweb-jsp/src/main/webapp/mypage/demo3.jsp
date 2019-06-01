<%@ page import="java.sql.Date" %><%--
  Created by IntelliJ IDEA.
  User: 11583
  Date: 2019/5/24
  Time: 14:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%--声明方法变量,声明的方法是带方法体的:在声明之前就编译好了--%>
<%!
    int result;
    int add(int a,int b){
        return a+b;
    }
%>

<%--使用方法或变量，Java代码片段,不能写方法声明，因为已经位于JSP中的某个方法中，使用时进行编译--%>
<%
    result = add(2, 4);
       out.println(result);
%>

<%--表达式一定是有返回值的--%>
result is<%=result%>
</body>
</html>
