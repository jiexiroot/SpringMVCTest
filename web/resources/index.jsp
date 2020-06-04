<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
      <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
      <script src="${pageContext.request.contextPath}/js/index.js"></script>
    <title>JX书城</title>
  </head>
  <body>
  <%
      Object user2=request.getSession().getAttribute("userIF");
      if(null == user2){
  %>
      <script>
          console.log("未登录")
          $(function () {
              layer.msg("您还没有登陆，请先登录");
          })
      </script>
  <%
      }
  %>
  <jsp:include page="head.jsp"/>
  <h3>${logIF}${username}</h3>
  <div>

      <div id="cList"></div>
      <div id="cInfo"></div>
  </div>
  <jsp:include page="footer.jsp"/>
  </body>
</html>
