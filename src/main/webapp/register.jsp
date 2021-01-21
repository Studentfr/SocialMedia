<%--
  Created by IntelliJ IDEA.
  User: Sungat Kaparov
  Date: 22.01.2021
  Time: 0:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/RegServlet" method="post">
    Username:<input type="text" name="username"/><br/>
    Password:<input type="password" name="password"/><br/>
    <input type="submit" value="register">
</form>
</body>
</html>
