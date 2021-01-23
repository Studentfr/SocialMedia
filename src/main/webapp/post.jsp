<%@ page import="models.PostView" %><%--
  Created by IntelliJ IDEA.
  User: Amiran
  Date: 23-Jan-21
  Time: 10:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%
    PostView p = (PostView)request.getAttribute("postView");
    request.setAttribute("postView", p);
    System.out.println("POstviewId = " + p.getId());
    if (p != null) {%>
    <div>
        <a href="profile?id=<%=p.getAuthorId()%>">Author Link</a>
        <h3>Title: <%=p.getTitle()%></h3>
        <p><%=p.getContent()%></p>
        <% if (p.isCommentable()) {%>
        <form action="${pageContext.request.contextPath}/CommentServlet" method="post">
            Add comment: <input type="text" name="comment" size="10"><br/>
            <input type="text" name="id" value="<%=p.getId()%>" style="display: none">
            <input type="submit" value="send">
        </form>
        <h4>Comments:</h4>
        <ul>
            <% for (String s:
                    p.getComments()) {
                %>
            <li><%=s%></li>
            <%
            } %>
        </ul>
        <%}%>
    </div>
<%} else out.print("<h2>Not Found</h2");
%>
