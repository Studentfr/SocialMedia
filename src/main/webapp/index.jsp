<%@ page import="models.User" %><%--
  Created by IntelliJ IDEA.
  User: Sungat Kaparov
  Date: 19.01.2021
  Time: 20:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    User s = (User) request.getSession().getAttribute("user");
    Boolean here = false;
    if (s != null){
        here = true;
    }
    if (here){
        response.sendRedirect("main.jsp");
    }
%>


<form action="AuthServlet" method="post">
    Username:<input type="text" name="username"/><br/>
    Password:<input type="password" name="password"/><br/>
    <input type="submit" value="login">
</form>
<a href="register.jsp">Registration</a>

