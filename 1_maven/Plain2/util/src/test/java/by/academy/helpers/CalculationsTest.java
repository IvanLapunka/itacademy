package by.academy.helpers;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculationsTest {

    @ParameterizedTest
    @MethodSource("doubleInitParameters")
    public void testGetAverageForAmountOfLastItems(List<Double> items, double expected, int lastAmount) {
        double actual = Calculations.getAverageForAmountOfLastItems(items, lastAmount);
        assertEquals(actual, expected);
    }

    private static Stream<Arguments> doubleInitParameters() {
        return Stream.of(
                Arguments.arguments(List.of(1.0, 2.0, 3.0), 2.0, 3),
                Arguments.arguments(List.of(1.0, 2.0, 3.0), 0, 0),
                Arguments.arguments(new ArrayList(), 0, 0)
        );
    }
}

