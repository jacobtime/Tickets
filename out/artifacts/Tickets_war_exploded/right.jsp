<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 2020/6/9
  Time: 16:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<script>
    function CreateSuccess() {
        alert("Create Succeed！");
    }
</script>
<head>
    <title>Right</title>
</head>
<body>
<script>
    let right_id = "<%=request.getAttribute("right")%>";
    if (right_id === "CreateSuccess")
        CreateSuccess();
    window.location.href="user.jsp";
</script>
</body>
</html>
