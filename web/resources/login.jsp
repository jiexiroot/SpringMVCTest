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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css">
    <script src="${pageContext.request.contextPath}/js/jquery-3.4.1.js"></script>
    <script src="${pageContext.request.contextPath}/js/layer.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/login.js"></script>
</head>
<body>
    <div class="login-newbg">
        <div class="login-newbg">
            <div class="loginbox">
                <div class="login-title">
                    密码登录
                </div>
                <div class="input-group ">
                    <span class="input-group-addon"><img class="img-rounded" src="/SpringMVCTest/images/user.png" width="16px"></span>
                    <input type="text" id="username" class="form-control" placeholder="请输入账户/手机号">
                </div>
                <div class="input-group ">
                    <span class="input-group-addon"><img class="img-rounded" src="/SpringMVCTest/images/pass.png" width="16px"></span>
                    <input type="password" id='password' class="form-control " placeholder="请输入密码">
                </div>
                <button type="button" id='sumbit' class="btn btn-primary btn-lg center-block " style="text-shadow: black 5px 3px 3px;">
                    登录
                </button>
                <div class="right-a">
                    <a href="/SpringMVCTest/resources/register.jsp" >免费注册</a>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
