<%--
  Created by IntelliJ IDEA.
  User: 11583
  Date: 2019/5/25
  Time: 14:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>九九乘法表</title>
</head>
<body>
<%!
String mathTable(){
    String result="";
    for(int i=1;i<=9;i++){
        for(int j=1;j<i;j++){
           String item=  j+"*"+i+"="+(i*j)+"&nbsp;&nbsp;";
           result=result+item;
        }
        result=result+"</br>";
    }
    return result;
}
%>
</body>
</html>
