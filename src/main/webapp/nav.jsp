<%@ page import="models.User" %><%--
  Created by IntelliJ IDEA.
  User: Amiran
  Date: 21-Jan-21
  Time: 10:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%
    User s = (User) request.getSession().getAttribute("user");
%>
<ul class="nav bg-secondary" style="display: flex">
    <li class="nav-item">
        <a class="nav-link" href="main.jsp">Home</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="posts">Posts</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="index.jsp">Index</a>
    </li>
    <%if (s != null) {%>
    <li class="nav-item">
        <a class="nav-link" href="profile?id=<%=s.getId()%>">My Profile</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="addPost.jsp">Add Post</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="${pageContext.request.contextPath}/LogoutServlet">Logout</a>
    </li>
    <%}%>

</ul>

