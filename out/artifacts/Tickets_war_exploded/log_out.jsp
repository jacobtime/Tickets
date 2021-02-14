<%@ page import="com.servlets.Global_var" %><%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 2020/6/10
  Time: 17:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Log out</title>
</head>
<body>
    <%
        Global_var.setUser("guest");
        response.sendRedirect("index.jsp");
    %>
</body>
</html>
