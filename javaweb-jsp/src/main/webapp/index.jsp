<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.util.StringJoiner" %>
<%@ include file="mypage/demo4.jsp"%>
<html>
<body>

<%----%>
<!---->
<h2>Hello World!</h2>
这是我的第一个jsp页面</br>
我包含了另一个页面</br>

<%--指令--%>
<h2>指令相关</h2>
<a href="/mypage/demo4.jsp">乘法表</a>
<jsp:include page="mypage/demo2.jsp"/>

</body>
</html>
