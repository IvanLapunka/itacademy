package by.academy.app;

import by.academy.helpers.LoginInfo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

public class Login extends HttpServlet {
    Map<String, String> map;
    AdminCredentials ac;

    class AdminCredentials {
        public final String login;
        public final String password;
        public AdminCredentials(String login, String password) {
            this.login = login;
            this.password = password;
        }
    }

    @Override
    public void init() throws ServletException {
//        String login = getServletConfig().getInitParameter("login");
//        String password = getServletConfig().getInitParameter("password");
        String login = getServletContext().getInitParameter("login");
        String password = getServletContext().getInitParameter("password");
        ac = new AdminCredentials(login, password);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (!validateCredentials(req, resp)) {
            return;
        }
        HttpSession session = req.getSession();
        LoginInfo loginInfo = new LoginInfo(ac.login);
        session.setAttribute("loginInfo", loginInfo);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/adminhome");
        requestDispatcher.forward(req, resp);
    }

    private boolean validateCredentials(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String login = req.getParameter("param_login");
        String password = req.getParameter("param_password");
        if (!(login.equals(ac.login) && password.equals(ac.password))) {
            resp.sendRedirect(req.getContextPath() + "/index.jsp");
            return false;
        }
        return true;
    }

}
