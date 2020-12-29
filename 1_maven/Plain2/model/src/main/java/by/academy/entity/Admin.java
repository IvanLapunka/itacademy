package by.academy.entity;

import java.util.ArrayList;
import java.util.List;

public class Admin extends Person{
    private List<Integer> marks;

    {
        marks = new ArrayList<>();
    }

    public Admin(String name, String surname, int age) {
        super(name, surname, age);
    }

    public Admin() {

    }
}
