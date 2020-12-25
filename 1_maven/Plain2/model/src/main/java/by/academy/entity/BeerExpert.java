package by.academy.entity;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class BeerExpert {
    public List<String> getBrands(String color) {
        List<String> brands = new ArrayList<>();
        if (color.equals("amber")) {
            brands.add("Amber 1");
            brands.add("Amber 2");
        } else {
            String v1 = stringToUtf8("Лидское");
            brands.add(v1);
            brands.add("Аливария");
            brands.add("Балтика");
        }
        return brands;
    }

    private String stringToUtf8(String s) {
        byte[] bytes = s.getBytes(StandardCharsets.UTF_8);
        String result = new String(bytes, StandardCharsets.UTF_8);
        return result;
    }
}
