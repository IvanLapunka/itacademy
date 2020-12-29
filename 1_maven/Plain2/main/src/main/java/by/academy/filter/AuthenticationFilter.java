package by.academy.filter;

import by.academy.helpers.LoginInfo;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AuthenticationFilter extends AbstractFilter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpSession session = req.getSession();
        if (session.isNew()) {
            ((HttpServletResponse)servletResponse).sendRedirect(req.getContextPath() + "/index.jsp");
            return;
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
