<%@ page import="models.Profile" %>
<%@ page import="models.Post" %>
<%@ page import="models.User" %><%--
  Created by IntelliJ IDEA.
  User: Amiran
  Date: 23-Jan-21
  Time: 10:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%
    Profile p = (Profile) request.getAttribute("profile");
    if (p != null) {%>
<div>
    <h3>Username: <%=p.getUsername()%></h3>
    <form action="SendReqServlet" method="post">
        <input type="hidden" value="<%=p.getId()%>" name="id">
        <% if ((Boolean)request.getAttribute("friendship") && (p.getId() != ((User)request.getSession().getAttribute("user")).getId())) {%>
        <div>You are friends</div>
        <%} else if (request.getAttribute("friendRequest") != null && !(Boolean)request.getAttribute("friendRequest")) {%>
        <input type="submit" value="Send Request">
        <%} else if (request.getAttribute("friendRequest") != null && (Boolean)request.getAttribute("friendRequest")) {%>
        <div>Request Sent</div>
        <%}%>
    </form>

    <h4>Posts:</h4>

        <% if (p.getVisibility() == 0 || ((User)session.getAttribute("user")).getUsername().equals(p.getUsername()) || (p.getVisibility() == 1 && request.getSession().getAttribute("user") != null)
        || ((Boolean)request.getAttribute("friendship"))) for (Post post:
             p.getPosts()) {
            %>
        <div>
            <a class="h4" href="post?id=<%=post.getId()%>"><%=post.getTitle()%></a>

            <p><%=post.getContent()%></p>
        </div>
            <%
        } else out.print("<div>Not Found or Inaccessible</div>");
    %>
</div>
<%} else out.print("<h2>Not Found</h2");
%>
