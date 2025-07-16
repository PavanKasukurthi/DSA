package Java.code360.easy;

import java.util.ArrayList;

public class FitnessTest {
    public static ArrayList<String> fittestTrainee(ArrayList<ArrayList<Integer>> oxygen) {
        ArrayList<String> result = new ArrayList<>();

        int[] averages = new int[3];
        int maxAverage = 0;

        for (int i = 0; i < 3; i++) {
            int sum = 0;
            for (int j = 0; j < 3; j++) {
                int value = oxygen.get(i).get(j);
                if (value > 0 && value <= 100) {
                    sum += value;
                }
            }
            int avg = Math.round(sum / 3);
            averages[i] = avg;
            maxAverage = Math.max(avg, maxAverage);
        }

        for (int i = 0; i < 3; i++) {
            if (averages[i] < 70) {
                result.add("Unfit");
            } else if (averages[i] == maxAverage) {
                result.add("Trainee" + (i + 1));
            }
        }

        return result;
    }
}
