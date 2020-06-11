<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>fristWeb</title>
    <style type="text/css">
        A {
            color: beige;
            text-decoration: none;
        }
        A:hover {
            color: red;
        }
        div{
            background: cornflowerblue;
            text-align: center;
            width: 150px;
            height: 30px;
        }
        span{
            font-size: 20px;
        }

    </style>
</head>
<body>
<h2>欢迎进入</h2>

<div> <a href="${pageContext.request.contextPath}/dept/shows"> <span>查看部门信息</span> </a> </div> <br>
<div> <a href="${pageContext.request.contextPath}/emp/shows"> <span> 查看员工信息 </span> </a> </div> <br>

</body>
</html>
