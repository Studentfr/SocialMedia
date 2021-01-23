<%@ page import="java.util.List" %>
<%@ page import="models.User" %>
<%@ page import="db.UserDB" %><%--
  Created by IntelliJ IDEA.
  User: Sungat Kaparov
  Date: 20.01.2021
  Time: 20:38
  To change this template use File | Settings | File Templates.
--%>
<h1>List of accounts</h1>
<p>Go to their profile to add to your friends</p>
<%
    List<User> users = UserDB.getInstance().getAllUsers();
    if (users != null){
        for (User u:
                users) {
%>
<div>
    <a class="h4" href="profile?id=<%=u.getId()%>"><%=u.getUsername()%></a>
</div>
<%
        }
    } else {%>
        <h1>No Posts Found or Accessible</h1>
<%}%>
