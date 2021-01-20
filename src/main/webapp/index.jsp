<%--
  Created by IntelliJ IDEA.
  User: Sungat Kaparov
  Date: 19.01.2021
  Time: 20:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<form action="AuthServlet">
    Username:<input type="text" name="name"/><br/>
    Password:<input type="password" name="password"/><br/>
    <input type="submit" value="login">
</form>
</body>
</html>
