<%--
  Created by IntelliJ IDEA.
  User: lei-long
  Date: 2020/5/21
  Time: 19:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri ="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
    <title>Title</title>

    <script type="text/javascript">

        function deleted(id){
            if (window.confirm("你确定删除改员工信息吗？")){
                window.location="${pageContext.request.contextPath}/emp/delete?id="+id;
                return false;
            }else {
                return false
            }
        }
    </script>
</head>
<body>
    <br><br>
    <H1 align="center">员工管理主页面</H1>
    <table border="1" width="75%" align="center">
        <tr>
            <th>#</th>
            <th>员工编号</th>
            <th>员工姓名</th>
            <th>员工性别</th>
            <th>员工入职日期</th>
            <th>员工工资</th>
            <th>员工所在部门</th>
            <th>操作</th>
        </tr>
        <c:choose>
            <c:when test="${!empty(emps)}" >
                <%--显示所有员工的信息--%>
                <c:forEach items="${emps}" var="emp" varStatus="status">
                    <tr>
                        <td align="center"> ${status.count} </td>
                        <td align="center"> ${emp.id} </td>
                        <td align="center"> ${emp.name} </td>
                        <td align="center"> ${emp.sex?'男':'女'} </td>
                        <td align="center"> <fmt:formatDate value="${emp.hireDate}" pattern="yyyy-MM-dd"/> </td>
                        <td align="center"> ${emp.salary} </td>
                        <td align="center"> ${emp.dept.name} </td>
                        <td align="center">
                            <a href="${pageContext.request.contextPath}/emp/update?id=${emp.id}">修改</a>
                            <a href="${pageContext.request.contextPath}/emp/delete?id=${emp.id}" onclick="return deleted(${emp.id})">删除</a>
                        </td>
                    </tr>
                </c:forEach>
            </c:when>
            <c:otherwise>
                <tr><td colspan="8">没有员工信息</td></tr>
            </c:otherwise>
        </c:choose>
        <tr><td colspan="8" align="right"><a href="${pageContext.request.contextPath}/emp/add">添加员工</a> </td></tr>
    </table>


</body>
</html>
