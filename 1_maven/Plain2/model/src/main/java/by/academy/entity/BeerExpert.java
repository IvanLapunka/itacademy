package by.academy.entity;

import java.util.ArrayList;
import java.util.List;

public class BeerExpert {
    public List<String> getBrands(String color) {
        List<String> brands = new ArrayList<>();
        if (color.equals("amber")) {
            brands.add("Amber 1");
            brands.add("Amber 2");
        } else {
            brands.add("Лидское");
            brands.add("Аливария");
            brands.add("Балтика");
        }
        return brands;
    }
}
