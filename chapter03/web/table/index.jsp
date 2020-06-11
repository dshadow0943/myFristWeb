<%--
  Created by IntelliJ IDEA.
  User: lei-long
  Date: 2020/4/1
  Time: 20:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录</title>
</head>
<body>

    <h1>用户登录</h1>
    <%
        if (application.getAttribute("info")!=null){
            out.print(application.getAttribute("info"));
            application.removeAttribute("info");
        }
    %>
    <form action="/chapter03_war_exploded/resp/text06" method="post">
        userName:<input type="text" name="name"/>
        password:<input type="password" name="pwd">
        <input type="submit" value="Login">
    </form>
</body>
</html>
