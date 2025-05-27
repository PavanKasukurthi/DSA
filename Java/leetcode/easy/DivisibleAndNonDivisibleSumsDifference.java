package Java.leetcode.easy;

import java.util.stream.*;

/* 2894. Divisible and Non-divisible Sums Difference */
public class DivisibleAndNonDivisibleSumsDifference {
    public static void main(String[] args) {
        System.out.println(sumDifference(10, 3));
    }

    public static int sumDifference(int n, int m) {
        int num1 = 0, num2 = 0;

        for (int i = 1; i <= n; i++) {
            if (i % m != 0)
                num1 += i;
            else
                num2 += i;
        }

        return num1 - num2;
    }

    public static int sumDifferenceUsingStreams(int n, int m) {
        return IntStream.rangeClosed(1, n)
                .map(i -> (i % m != 0) ? i : -i)
                .sum();
    }
}
