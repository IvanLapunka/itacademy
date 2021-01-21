package by.academy.app;

import by.academy.constants.ServletPaths;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value="/adminHome")
public class AdminHome extends HttpServlet {
    Logger log = LoggerFactory.getLogger(AdminHome.class);
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect(req.getContextPath() + ServletPaths.ADMIN_HOME_VIEW);

    }
}
