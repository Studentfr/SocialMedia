<%@ page import="java.util.List" %>
<%@ page import="models.Post" %><%--
  Created by IntelliJ IDEA.
  User: Amiran
  Date: 21-Jan-21
  Time: 9:54 PM
  To change this template use File | Settings | File Templates.
--%>
<% if (request.getAttribute("posts") != null) {%>
    <%
        List<Post> posts = (List<Post>) request.getAttribute("posts");
        for (Post p:
             posts) {
            %>
<div>
    <a class="h4" href="post?id=<%=p.getId()%>"><%=p.getTitle()%></a>

    <p><%=p.getContent()%></p>
</div>
<%
        }
    %>
<%} else {%>
    <h1>No Posts Found or Accessible</h1>
<%}%>
