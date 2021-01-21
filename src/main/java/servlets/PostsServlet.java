package servlets;

import db.PostsDB;
import models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/posts")
public class PostsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String title = request.getParameter("title");
            String content = request.getParameter("content");
            int visibility = Integer.parseInt(request.getParameter("visibility"));
            User u = (User) request.getSession().getAttribute("user");
            PostsDB.getInstance().addPost(title, content, visibility, u.getId());
            request.getRequestDispatcher("main.jsp").include(request, response);
        } catch (Exception e ) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
