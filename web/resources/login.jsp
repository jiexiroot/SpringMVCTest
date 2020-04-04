<%--
  Created by IntelliJ IDEA.
  User: GOU
  Date: 2020/4/3
  Time: 21:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录界面</title>
</head>
<body>
    <form action="login" method="post">
        <span>用户名：</span><input type="text" name="loginId"/><br>
        <span>密码：</span><input type="password" name="loginPwd"/><br>
        <input type="submit" value="登录"/>
    </form>
</body>
</html>
