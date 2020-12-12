package by.academy.helpers;
import java.util.List;

public class Calculations {

    public static double getAverageForAmountOfLastItems(List<Integer> list, int items) {
        if (0 == items)
            return 0;

        int sum = 0;
        int elementens = items;
        for (int i = list.size() - 1; i >= 0; i--){
            if (elementens > 0) {
                sum += list.get(i);
                elementens--;
            } else {
                break;
            }
        }
        return 1.0 * sum / items;
    }
}
