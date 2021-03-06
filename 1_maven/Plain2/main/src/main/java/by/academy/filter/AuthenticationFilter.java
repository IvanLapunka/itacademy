package by.academy.filter;

import by.academy.constants.ServletPaths;
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
    private int sessionTimeOut;
    private static final Logger log = LoggerFactory.getLogger(AuthenticationFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String login = filterConfig.getServletContext().getInitParameter("login");
        String password = filterConfig.getServletContext().getInitParameter("password");
        credencials = new AdminCredentials(login, password);
        try {
            sessionTimeOut = Integer.parseInt(filterConfig.getServletContext().getInitParameter("sessionTimeOut"));;
        } catch (NumberFormatException e){
            sessionTimeOut = 30;
        }
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        HttpSession session = req.getSession();
        String login = servletRequest.getParameter("param_login");
        String password = servletRequest.getParameter("param_password");
        LoginInfo loginInfo = (LoginInfo) session.getAttribute("loginInfo");
        if (loginInfo == null) {
            if ((login == null && password == null
                    && !ServletPaths.LOGIN_VIEW.equals(req.getServletPath()))) {
                resp.sendRedirect(req.getContextPath() + ServletPaths.LOGIN_VIEW);
                return;
            } else if (login != null && password != null) {
                log.info("Authentication Login: {}", login);
                if (!(credencials.login.equals(login) && credencials.password.equals(password))) {
                    RequestDispatcher requestDispatcher = req.getRequestDispatcher(ServletPaths.LOGIN_VIEW);
                    req.setAttribute("error_message", "Login or password is incorrect.");
                    requestDispatcher.forward(req, resp);
                    return;
                } else {
                    session.setAttribute("loginInfo", new LoginInfo(login));
                    session.setMaxInactiveInterval(sessionTimeOut);
                }
            }
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
