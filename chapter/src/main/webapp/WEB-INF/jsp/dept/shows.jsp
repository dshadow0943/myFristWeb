<%--
  Created by IntelliJ IDEA.
  User: lei-long
  Date: 2020/6/9
  Time: 20:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Title</title>
    <link href="${pageContext.request.contextPath}bootstrap-3.3.7-dist/dist/css/bootstrap.min.css" rel="stylesheet">
    <style type="text/css">
        .table{
            margin-top:50px;
            text-align:center;
        }
        thead{
            font-weight: bold;
        }
    </style>
    <script src="${pageContext.request.contextPath }/jquery-1.12.4/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath }/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>

</head>
<body>
<div class="container" align="center">
    <div class="row">
        <div class="col-md-6 col-md-offset-3">
            <table class="table table-striped table-bordered table-hover" >
                <thead>
                <tr>
                    <td>#</td><td>部门编号</td><td>部门名称</td><td>操作</td>
                </tr>
                </thead>
                <tbody>
                <c:choose>
                    <c:when test="${depts!=null}">
                        <c:forEach items="${depts}" var="dept" varStatus="status">
                            <tr>
                                <td>${status.count}</td>
                                <td>${dept.id}</td>
                                <td>${dept.name}</td>
                                <td>
                                    <button type="button" class="btn btn-primary btn-sm">
                                        <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                                        修改
                                    </button>

                                    <button type="button" class="btn btn-danger btn-sm">
                                        <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
                                        删除
                                    </button>
                                </td>
                            </tr>
                        </c:forEach>
                    </c:when>
                    <c:otherwise>
                        <tr><td colspan="4">对不起，没有你要查询的部门信息！</td></tr>
                    </c:otherwise>
                </c:choose>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>
