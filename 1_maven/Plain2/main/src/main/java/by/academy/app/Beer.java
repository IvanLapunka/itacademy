package by.academy.app;

import by.academy.entity.BeerExpert;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class Beer extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String option = req.getParameter("color");
        BeerExpert be = new BeerExpert();
        List<String> result = be.getBrands(option);
        req.setAttribute("styles", result);
        RequestDispatcher view = req.getRequestDispatcher("/result");
        view.forward(req, resp);

    }
}
