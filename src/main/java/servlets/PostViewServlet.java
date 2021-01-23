package servlets;

import db.PostsDB;
import models.PostView;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/post")
public class PostViewServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int postId = Integer.parseInt(request.getParameter("id"));
        PostView p = PostsDB.getInstance().getPostViewById(postId);
        request.setAttribute("postView", p);
        request.getRequestDispatcher("post.jsp").include(request,response);
    }
}
