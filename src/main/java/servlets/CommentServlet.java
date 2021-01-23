package servlets;

import db.PostsDB;
import models.PostView;
import models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/CommentServlet")
public class CommentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String text = request.getParameter("comment");
            int author_id;
            String post_id;
            System.out.println("txt = " + text);
            post_id = request.getParameter("id");
            System.out.println("id = " + post_id);
            User u = (User)request.getSession().getAttribute("user");
            author_id = u.getId();
            PostsDB.getInstance().addComment(text,author_id,Integer.parseInt(post_id));
            request.getRequestDispatcher("posts.jsp").include(request, response);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("catching exception");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
