package Java.Java8StreamAPI;

import java.util.*;
import java.util.stream.*;

public class NumericalStreams {
    public static void main(String[] args) {
        int[] numbers = { 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 13, 17, 20 };
        // primeNumbers(numbers);

        evenOddPartitioner(numbers);
    }

    public static void primeNumbers(int[] num) {
        List<Integer> primes = Arrays.stream(num)
                .boxed()
                .filter(NumericalStreams::isPrime)
                .collect(Collectors.toList());

        System.out.println(primes);
    }

    public static boolean isPrime(int n) {
        if (n <= 1)
            return false;

        return IntStream.rangeClosed(2, (int) Math.sqrt(n))
                .allMatch(i -> n % i != 0);
    }

    // odd and even numbers in a single line
    public static void evenOddPartitioner(int[] nums) {
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());

        Map<Boolean, List<Integer>> partitioned = list.stream()
                .collect(Collectors.partitioningBy(n -> n % 2 == 0));

        System.out.println("Even numbers " + partitioned.get(true));
        System.out.println("Odd numbers " + partitioned.get(false));
    }
}
