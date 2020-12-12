package by.academy.app;

import by.academy.entity.Employee;
import by.academy.helpers.Calculations;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Employee e1 = new Employee("Vasja", "Pupkin", Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));
        Employee e2 = new Employee("Ivan", "Ivanov", new ArrayList<>());
        Employee e3 = new Employee("Petr", "Petrovich", Arrays.asList(1));

        int months = 6;
        getAverageSalary(e1, months);
        getAverageSalary(e2, months);
        getAverageSalary(e3, months);

        months = 0;
        getAverageSalary(e1, months);

        months = 10;
        getAverageSalary(e3, months);


    }

    public static void getAverageSalary(Employee e, int months) {
        System.out.println(e.toString()
                + " has avarage salary for the last " + months + " month: "
                + Calculations.getAverageForAmountOfLastItems(e.getSalaries(), months));
    }
}

