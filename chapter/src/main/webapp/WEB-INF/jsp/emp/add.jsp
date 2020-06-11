<%--
  Created by IntelliJ IDEA.
  User: lei-long
  Date: 2020/6/11
  Time: 11:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<br><br><h1 align="center"> 员工添加页面  </h1>
<form action="${pageContext.request.contextPath}/emp/add" method="POST">
    <table border="1" width="60%" align="center">
        <tr><td align="right">员工编号</td><td><input type="text" name="id" value="${param.id}"><font color="red">${errors.id}</font></td></tr>
        <tr><td align="right">员工姓名</td><td><input type="text" name="name" value="${param.name}"><font color="red">${errors.name}</font></td></tr>
        <tr><td align="right">员工性别</td><td><input type="radio" name="sex" value="true" ${fn:contains(param.sex, 'true')?'checked':''}>男&nbsp;&nbsp;&nbsp;
            <input type="radio" name="sex" value="false" ${fn:contains(param.sex, 'false')?'checked':''}>女</td></tr>
        <tr><td align="right">员工入职日期</td><td><input type="date" name="hireDate" value="${param.hireDate}"><font color="red">${errors.hireDate}</font></td></tr>
        <tr><td align="right">员工工资</td><td><input type="text" name="salary" value="${param.salary}"><font color="red">${errors.salary}</font></td></tr>
        <tr><td align="right">员工所在部门</td>
            <td>
                <select name="dept.id">
                    <c:forEach items="${depts}" var="dept">
                        <option value="${dept.id}" ${fn:contains(param['dept.id'], dept.id)?'selected': ''}>${dept.name}</option>
                    </c:forEach>
                </select>
            </td></tr>
        <tr><td colspan="6" align="center">
            <input type="submit" value="添加新员工">&nbsp;&nbsp;&nbsp;
            <input type="reset" value="重置">
        </td></tr>
    </table>


</form>
</body>
</html>
