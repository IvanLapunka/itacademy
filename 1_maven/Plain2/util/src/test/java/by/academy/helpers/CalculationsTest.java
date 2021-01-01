package by.academy.helpers;

import org.junit.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculationsTest {
    @Test
    public void testGetAverageForAmountOfLastItems() {
        List<Integer> given = List.of(1, 2, 3, 4, 5, 6, 7);
        int items = 7;
        double expected = 4;
        double actual = Calculations.getAverageForAmountOfLastItems(given, items);
        assertEquals(actual, expected);
    }
}
