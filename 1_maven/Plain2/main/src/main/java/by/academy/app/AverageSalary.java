package by.academy.app;

import by.academy.entity.Person;
import by.academy.entity.Teacher;
import by.academy.helpers.Calculations;
import by.academy.repository.PersonRepository;
import by.academy.repository.PersonRepositoryInMemory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@WebServlet(value="/averageSalary")
public class AverageSalary extends HttpServlet {
    private PersonRepository rep;

    @Override
    public void init() throws ServletException {
        rep = PersonRepositoryInMemory.getInstance();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Teacher> teachers = getTeachers();
        List<Double> salaries = getSalaries(teachers);
        double averageSalary = Calculations.getAverageForAmountOfLastItems(salaries, salaries.size());
        req.setAttribute("averageSalary", averageSalary);
        req.setAttribute("teachers", teachers);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/average-salary");
        requestDispatcher.forward(req, resp);
    }

    private List<Teacher> getTeachers() {
        List<Teacher> result = new ArrayList<>();
        for(Person person: rep.findAll()) {
            if (person instanceof Teacher){
                result.add((Teacher)person);
            }
        }
        return result;
    }

    private List<Double> getSalaries(List<Teacher> teachers) {
        List<Double> result = new LinkedList<>();
        for(Teacher teacher: teachers) {
            result.add(teacher.getSalary());
        }
        return result;
    }
}
