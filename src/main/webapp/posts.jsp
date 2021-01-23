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
    <h4><%=p.getTitle()%></h4>
    <p><%=p.getContent()%></p>
</div>
<%
        }
    %>
<%} else {%>

<%}%>
