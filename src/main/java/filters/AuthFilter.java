package filters;

import com.sun.deploy.cache.CacheEntry;
import db.UserDB;
import models.User;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.json.JsonObject;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class AuthFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Opened AuthFilter");
        PrintWriter out = servletResponse.getWriter();
        String password = servletRequest.getParameter("password");
        String username = servletRequest.getParameter("username");
        boolean logged = false;
        List<User> list = UserDB.getInstance().getAllUsers();
        for (User u:
                list) {
            if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
                ((HttpServletRequest) servletRequest).getSession().setAttribute("user", u);
                logged = true;
                filterChain.doFilter(servletRequest, servletResponse);
            }
        }
        if (!logged){
            out.print("username or password error!");
            RequestDispatcher rd = servletRequest.getRequestDispatcher("index.jsp");
            rd.include(servletRequest, servletResponse);
        }

    }

    @Override
    public void destroy() {

    }
}
