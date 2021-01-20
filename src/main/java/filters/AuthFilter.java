package filters;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;

public class AuthFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        PrintWriter out = servletResponse.getWriter();

        String password = servletRequest.getParameter("password");
        if (password.equals("admin")) {
            filterChain.doFilter(servletRequest, servletResponse);//sends request to next resource
        } else {
            out.print("username or password error!");
            RequestDispatcher rd = servletRequest.getRequestDispatcher("index.html");
            rd.include(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
