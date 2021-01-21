package filters;

import javax.servlet.*;
import java.io.IOException;

public class LayoutFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Opened LayoutFilter");
        servletRequest.getRequestDispatcher("nav.jsp").include(servletRequest, servletResponse);
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
