package Java.leetcode.easy;

import java.util.Arrays;

public class FindNUniqueIntegersSumUptoZero {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sumZero(5)));
    }

    public static int[] sumZero(int n) {
        int[] result = new int[n];
        int index = 0;
        for (int i = 1; i < n / 2; i++) {
            result[index++] = i;
            result[index++] = -i;
        }

        return result;
    }
}