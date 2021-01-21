package filters;

import javax.servlet.*;
import java.io.IOException;

public class StructureFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Opened StructureFilter");
        servletRequest.getRequestDispatcher("header.jsp").include(servletRequest, servletResponse);
        filterChain.doFilter(servletRequest, servletResponse);
        servletRequest.getRequestDispatcher("footer.jsp").include(servletRequest, servletResponse);
    }
}
