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
    function UserNotExists() {
        alert("User not Found！");
    }
    function PassNotRight() {
        alert("Password not Correct！");
    }
    function PassNotSame() {
        alert("Twice Password is not Same！");
    }
    function NoLogin() {
        alert("Guest Login, request user login!");
    }
    function UserHaveExist(){
        alert("User is Exist！");
    }
</script>
<head>
    <title>Wrong</title>
</head>
<body>
<script>
    let wrong_id = "<%=request.getAttribute("wrong")%>";
    if (wrong_id === "PassWrong")
        PassNotRight();
    else if(wrong_id === "UserNotExist")
        UserNotExists();
    else if(wrong_id === "PassNotSame")
        PassNotSame();
    else if(wrong_id === "NoLogin" )
        NoLogin();
    else if(wrong_id === "UserHaveExist")
        UserHaveExist();

    window.location.href="index.jsp";
</script>
</body>
</html>
