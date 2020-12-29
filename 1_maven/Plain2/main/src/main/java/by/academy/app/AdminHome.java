package by.academy.app;

import by.academy.helpers.LoginInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AdminHome extends HttpServlet {
    Logger log = LoggerFactory.getLogger(AdminHome.class);
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        LoginInfo loginInfo = (LoginInfo)session.getAttribute("loginInfo");
        if (loginInfo != null) {
            resp.sendRedirect(req.getContextPath() + "/adminhomejsp");
        } else {
            resp.sendRedirect(req.getContextPath() + "/index.jsp");
        }
    }
}
