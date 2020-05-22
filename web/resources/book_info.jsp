<%--
  Created by IntelliJ IDEA.
  User: GOU
  Date: 2020/5/13
  Time: 16:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" scope="session" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <link rel="stylesheet" href="${path}/css/bootstrap.min.css">
    <script src="${path}/js/jquery-3.4.1.js"></script>
    <script src="${path}/js/layer.js"></script>
    <script src="${path}/js/bootstrap.min.js"></script>
    <script src="${path}/js/book_info.js"></script>

    <style>
        table,th{
            text-align:center
        }
    </style>
    <title>图书信息</title>
</head>
<body>
<%--    <jsp:include page="head.jsp"/>--%>

    <div class="panel panel-primary">
        <div class="panel-heading">
            <div class="panel-title" style="height: 35px">
                <p class="pull-left">以下是种类为：${info_book.Cname}</p>
<%--                <button type="button" onclick="location='${path}/resources/index.jsp'" class="pull-right btn btn-default">返回主界面</button>--%>
            </div>

        </div>
        <div class="panel-body">
            <table id="table" class="table table-hover">
                <thead>
                    <tr id="">
                        <th>选择</th>
                        <th>ISBN</th>
                        <th>书名</th>
                        <th>作者</th>
                        <th>单价</th>
                        <th>操作</th>
                    </tr>
                </thead>
                <tbody>
                    <c:choose>
                        <c:when test="${not empty info_book.bookList}">
                            <td>
                                <button class="btn btn-danger" id="delChoose">批量删除</button>
                            </td>
                            <c:forEach items="${info_book.bookList}" var="books">
                                <tr>
                                    <td><input name="ids" value="${books.id}" type="checkbox"></td>
                                    <td>${books.iSBN}</td>
                                    <td>${books.title}</td>
                                    <td>${books.author}</td>
                                    <td>${books.unitPrice}</td>
                                    <td><button class="btn btn-danger" id="delThis" onclick="delThis(this,'${books.id}')">删除</button></td>
                                </tr>
                            </c:forEach>
                        </c:when>
                        <c:otherwise>
                            <tr>
                                <td colspan="6"><h2>没有该种类的图书信息</h2></td>
                            </tr>
                        </c:otherwise>
                    </c:choose>


                </tbody>
            </table>
        </div>
    </div>
<%--    <jsp:include page="footer.jsp"/>--%>
</body>
</html>
