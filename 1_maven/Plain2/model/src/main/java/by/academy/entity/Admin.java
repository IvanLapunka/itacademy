package by.academy.entity;

import java.util.ArrayList;
import java.util.List;

public class Admin extends Person{
    private List<Integer> marks;

    {
        marks = new ArrayList<>();
    }

    public Admin(Long id, String name, String surname, int age) {
        super(id, name, surname, age);
    }

    public Admin() {

    }
}
