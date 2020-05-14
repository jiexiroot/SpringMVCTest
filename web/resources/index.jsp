<%--
  Created by IntelliJ IDEA.
  User: GOU
  Date: 2020/4/3
  Time: 20:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
      <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
      <link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css">
      <script src="${pageContext.request.contextPath}/js/jquery-3.4.1.js"></script>
      <script src="${pageContext.request.contextPath}/js/layer.js"></script>
      <script src="${pageContext.request.contextPath}/js/index.js"></script>
      <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <title>JX书城</title>
  </head>
  <body>
  <jsp:include page="head.jsp"/>
  <h1>登陆成功,欢迎您${username}</h1>
  <div id="cList"></div>
  <jsp:include page="footer.jsp"/>
  </body>
</html>
