package by.academy.helpers;
import java.util.List;

public class Calculations {

    public static double getAverageForAmountOfLastItems(List<Double> list, int items) {
        if (0 == items)
            return 0;

        double sum = 0;
        int elementens = items;
        for (int i = list.size() - 1; i >= 0; i--){
            if (elementens > 0) {
                sum += list.get(i);
                elementens--;
            } else {
                break;
            }
        }
        return sum / items;
    }
}
