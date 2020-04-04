<%--
  Created by IntelliJ IDEA.
  User: GOU
  Date: 2020/4/4
  Time: 9:31
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <link rel="stylesheet" href="../css/register.css">
    <script src="../js/jquery-3.4.1.js"></script>
    <script src="../js/bootstrap.min.js"></script>
    <script src="../js/layer.js"></script>
</head>
<body>
<form action="register" method="post">
    <span>用户名：</span><input type="text" name="loginId"/><br>
    <span>密码：</span><input type="password" name="loginPwd"/><br>
    <input type="submit" value="登录"/>
</form>
</body>
</html>
