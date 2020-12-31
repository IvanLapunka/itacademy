package by.academy.filter;

import by.academy.helpers.AdminCredentials;
import by.academy.helpers.LoginInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AuthenticationFilter extends AbstractFilter {
    private AdminCredentials credencials;
    private static final Logger log = LoggerFactory.getLogger(AuthenticationFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String login = filterConfig.getServletContext().getInitParameter("login");
        String password = filterConfig.getServletContext().getInitParameter("password");
        credencials = new AdminCredentials(login, password);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpSession session = req.getSession();
        String login = servletRequest.getParameter("param_login");
        String password = servletRequest.getParameter("param_password");
        LoginInfo loginInfo = (LoginInfo) session.getAttribute("loginInfo");
        if (!(login == null && password == null || loginInfo != null)) {
            log.info("Authentication Login: {}", login);
            if (!(credencials.login.equals(login) && credencials.password.equals(password))) {
                ((HttpServletResponse) servletResponse).sendRedirect(req.getContextPath() + "/index.jsp");
                return;
            } else {
                session.setAttribute("loginInfo", new LoginInfo(login));
            }
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
