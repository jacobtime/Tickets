<%@ page import="java.util.Date" %>
<%@ page import="org.w3c.dom.html.HTMLImageElement" %>
<%@ page import="com.servlets.Global_var" %>
<%@ page import="com.bean.Order" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="com.bean.Train" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Welcome</title>
    <style>
        * {
            box-sizing: border-box;
        }

        body {
            font-family: Arial;
            padding: 1%;
            background: #f1f1f1;
        }

        /* 头部标题 */
        .header {
            padding: 3%;
            text-align: center;
            background: white;
        }

        .header h1 {
            font-size: 50px;
        }

        /* 导航条 */
        .topnav {
            overflow: hidden;
            background-color: #333;
        }

        /* 导航条链接 */
        .topnav a {
            float: left;
            display: block;
            color: #f2f2f2;
            text-align: center;
            padding: 1.4% 1.6%;
            text-decoration: none;
        }

        /* 链接颜色修改 */
        .topnav a:hover {
            background-color: #ddd;
            color: black;
        }

        /* 创建两列 */
        /* Left column */
        .leftcolumn {
            float: left;
            width: 65%;
        }

        /* 右侧栏 */
        .rightcolumn {
            float: left;
            width: 35%;
            background-color: #f1f1f1;
            padding-left: 2%;
        }

        /* 图像背景部分 */
        .fakeimg {
            background-color: #aaa;
            width: 100%;
            padding: 2%;
        }

        .imgSize{
            width: 100%;
            padding: 0;
        }

        /* 文章卡片效果 */
        .card {
            background-color: white;
            padding: 2%;
            margin-top: 20px;
        }

        /* 列后面清除浮动 */
        .row:after {
            content: "";
            display: table;
            clear: both;
        }

        /* 底部 */
        .footer {
            padding: 2%;
            text-align: center;
            background: #ddd;
            margin-top: 2%;
        }

        .form{
            background-color: white;
            padding: 2%;
        }

        /* 响应式布局 - 屏幕尺寸小于 800px 时，两列布局改为上下布局 */
        @media screen and (max-width: 800px) {
            .leftcolumn, .rightcolumn {
                width: 100%;
                padding: 0;
            }
        }

        /* 响应式布局 -屏幕尺寸小于 400px 时，导航等布局改为上下布局 */
        @media screen and (max-width: 400px) {
            .topnav a {
                float: none;
                width: 100%;
            }
        }
    </style>
    <%
        List<Train> trainList = new ArrayList<Train>();

        try {
            trainList = Global_var.getAllTrain();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    %>
    <script type="text/javascript">
        function time(){
            const time = new Date();
            const year = time.getFullYear();
            const month = time.getMonth() + 1;
            const day = time.getDate();
            const hour = time.getHours();
            const minute = time.getMinutes();
            const second = time.getSeconds();
            document.getElementById("showtime").innerHTML="Today is " + year + "-" + month + "-" + day + "  " + (hour >= 10 ? hour : "0" + hour) + ":" + (minute >= 10 ? minute : "0" + minute) + ":" + (second >= 10 ? second : "0" + second);
        }
        function Back() {
            window.location.href = "management.jsp";
        }
        setInterval("time()", 1000);
    </script>
</head>
<body>

<div class="header">
    <h1>Welcome to Join My 12306</h1>
</div>

<div class="topnav">
    <a href="https://www.12306.cn/index/index.html">Real 12306</a>
    <a href="./search.jsp">Search</a>
    <a href="#" style="float:right">Hello,<%=Global_var.getUser()%></a>
    <a href="./log_out.jsp" style="float:right">Log out</a>
</div>

<div class="row">
    <div class="leftcolumn">
        <div class="card">
            <h2>Welcome to My 12306</h2>
            <p id="showtime">Time starting......</p>
            <div class="fakeimg" ><img class="imgSize" src="./img/travel.jpg" ></div>
            <p>Jiangxi is a beautiful place to relax your self when you want to enjoy the nature.</p>
        </div>
        <div class="card">
            <h2>Take a train to a beautiful place</h2>
            <div class="fakeimg" ><img class="imgSize" src="./img/trains.jpg" ></div>
            <p>Too tired for working, just buy a ticket for a trip now!</p>
        </div>
    </div>
    <div class="rightcolumn">
        <div class="card">
            <h2 align="center">Train</h2>
            <form class="form" action="Train_manage">
                <table  border="1px"  align="center" style="border-spacing: 5px;border-color: black" cellspacing="20px" >
                    <tr align="center">
                        <td >ID</td>
                        <td >Type</td>
                        <td >Seat</td>
                        <td >Remain</td>
                    </tr>
                    <%
                        for(int i = 0; i < trainList.size(); i++){
                    %>
                    <tr align="center">
                        <td><%=trainList.get(i).getID()%></td>
                        <td><%=trainList.get(i).getType()%></td>
                        <td><%=trainList.get(i).getSeat()%></td>
                        <td><%=trainList.get(i).getRemain()%></td>
                    </tr>
                    <% }%>
                    <tr>
                </table>
                <table  align="center" cellspacing="10px">
                    <tr><td>ID:</td><td><input type="text" name="id"></td></tr>
                    <tr><td>Type:</td><td><input type="text" name="type"></td></tr>
                    <tr><td>Seat:</td><td><input type="text" name="seat"></td></tr>
                </table>
                <table align="center" cellspacing="10px">
                    <tr> <td><input type="submit" value="delete" name="option" ></td>
                     <td><input type="submit" value="modify" name="option" ></td>
                     <td><input type="submit" value="add" name="option" ></td></tr>
                    <tr><td><input type="submit" value="find" name="option"></td>
                    <td><input type="button" value="Back"  onclick="Back()"></td></tr>

                </table>
            </form>
        </div>
        <div class="card">
            <h2>About Me</h2>
            <div ><img class="imgSize" src="./img/pictures.jpg" ></div>
            <p>A lazy man who write nothing...</p>
        </div>

        <div class="card">
            <h2>Follow me</h2>
            <p>QQ:1545858682</p>
            <p>Email:1545858682@qq.com</p>
        </div>
    </div>
</div>

<div class="footer">
    <h2>李景涛 8002118060 ©All rights received</h2>
</div>

</body>
</html>
