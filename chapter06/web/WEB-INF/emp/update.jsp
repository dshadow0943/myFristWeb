<%--
  Created by IntelliJ IDEA.
  User: lei-long
  Date: 2020/6/5
  Time: 23:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<br><br><h1 align="center"> 员工修改页面  </h1>
<form action="${pageContext.request.contextPath}/emp/update" method="POST">
    <table border="1" width="60%" align="center">
        <tr><td align="right">员工编号</td><td>${emp.id}</td></tr>
        <input type="hidden" name="id" value="${emp.id}"/>
        <tr><td align="right">员工姓名</td><td><input type="text" name="name" value="${emp.name}"><font color="red">${errors.name}</font></td></tr>
        <tr><td align="right">员工性别</td><td><input type="radio" name="sex" value="true" ${fn:contains(emp.sex, 'true')?'checked':''}>男&nbsp;&nbsp;&nbsp;
            <input type="radio" name="sex" value="false" ${fn:contains(emp.sex, 'false')?'checked':''}>女</td></tr>
        <tr><td align="right">员工入职日期</td><td><input type="date" name="hireDate" value='<fmt:formatDate value="${emp.hireDate}" pattern="yyyy-MM-dd"/>'><font color="red">${errors.hireDate}</font></td></tr>
        <tr><td align="right">员工工资</td><td><input type="text" name="salary" value="${emp.salary}"><font color="red">${errors.salary}</font></td></tr>
        <tr><td align="right">员工所在部门</td>
            <td>
                <select name="dept.id">
                    <c:forEach items="${depts}" var="dept">
                        <option value="${dept.id}" ${fn:contains(param['emp.id'], dept.id)?'selected': ''}>${dept.name}</option>
                    </c:forEach>
                </select>
            </td></tr>
        <tr><td colspan="6" align="center">
            <input type="submit" value="修改员工">&nbsp;&nbsp;&nbsp;
            <input type="reset" value="重置">
        </td></tr>
    </table>


</form>
</body>
</html>
