package by.academy.app;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Home extends HttpServlet {
    @Override
    public void init() throws ServletException {

    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.service(req, resp);
        String login = req.getParameter("param_login");
        String password = req.getParameter("param_password");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/redirect");

        requestDispatcher.forward(req, resp);

        //writer.println("<html><body><h1>" + login + " : " + password + "</html></body></h1>");
    }
}
