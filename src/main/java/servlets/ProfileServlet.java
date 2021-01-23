package servlets;

import db.FriendsDB;
import db.UserDB;
import models.Profile;
import models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Profile p = UserDB.getInstance().getProfileById(id);
        request.setAttribute("profile", p);
        User u = (User)request.getSession().getAttribute("user");
        boolean friendship = false;
        if (u != null) {
            friendship = FriendsDB.getInstance().isFriend(u.getId(), id);
        }
        request.setAttribute("friendship", friendship);
        request.getRequestDispatcher("profile.jsp").include(request, response);
    }
}
