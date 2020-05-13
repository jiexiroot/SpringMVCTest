<%--
  Created by IntelliJ IDEA.
  User: GOU
  Date: 2020/4/27
  Time: 11:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试JSON交互</title>
    <script src="/SpringMVCTest/js/jquery-3.4.1.js"></script>
    <script src="../js/layer.js"></script>
    <script type="text/javascript">

        $(function(){

            $('#btn1').bind('click', function postJson(){
                //获取输入的用户名和密码
                var username = $("#username").val();
                var password = $("#password").val();
                $.ajax({
                    url : "${pageContext.request.contextPath}/testJson",
                    type : "post",
                    //data发送的数据
                    data : JSON.stringify({username:username,password:password}),
                    //定义发送数据的数据格式为JSON字符串
                    contentType : "application/json;charset=UTF-8",
                    //定义回调响应的数据格式为JSON字符串，该属性可以省略
                    dataType : "json",
                    //成功响应的结果
                    success : function (data) {
                        if (data!=null){
                            layer.msg("您输入的用户名为:"+data.username+"密码为:"+data.password);
                        }

                    }
                });
            });
        })
    </script>
</head>
<body>
    <form>
        用户名：<input type="text" name="username" id="username"> <br/>
        密&nbsp;&nbsp;码:<input type="password" name="password" id="password"><br/>
        <input type="button" value="测试JSON交互" id="btn1">

    </form>
</body>
</html>
