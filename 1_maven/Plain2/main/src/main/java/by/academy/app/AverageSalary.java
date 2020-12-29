package by.academy.app;

import by.academy.entity.Person;
import by.academy.entity.Teacher;
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
import java.util.List;

@WebServlet(value="/average-salary")
public class AverageSalary extends HttpServlet {
    private PersonRepository rep;

    @Override
    public void init() throws ServletException {
        rep = PersonRepositoryInMemory.getInstance();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("averageSalary",averageSalary());
        req.setAttribute("teachers", getTeachers());
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/average");
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

    private double averageSalary() {
        double salary = 0;
        int count = 0;
        for (Person person :
                rep.findAll()) {
            if (person instanceof Teacher) {
                salary += (((Teacher) person).getSalary());
                count++;
            }
        }

        return count > 0 ? salary / count : 0;
    }
}
