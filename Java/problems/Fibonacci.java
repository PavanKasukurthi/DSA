package Java.problems;

import java.util.HashMap;
import java.util.stream.Stream;

public class Fibonacci {

    public static void main(String[] args) {
        // System.out.println(dynamicFibonacci2(4));
        // fibonacciUsingLoop(10);
        fibonacciUsingStreams(10);
    }

    // USING JAVA 8 STREAMS
    public static void fibonacciUsingStreams(int n) {
        Stream.iterate(new long[] { 0, 1 }, f -> new long[] { f[1], f[0] + f[1] })
                .limit(n)
                .map(f -> f[0])
                .forEach(System.out::println);
    }

    // Recursive approach
    public static int fibonacci(int n) {
        if (n == 1 || n == 2)
            return 1;

        else
            return fibonacci(n - 1) + fibonacci(n - 2);
    }

    // USING LOOP
    public static void fibonacciUsingLoop(int n) {
        int a = 0, b = 1;
        System.out.print(a + " " + b + " ");

        for (int i = 2; i < n; i++) {
            int next = a + b;
            System.out.print(next + " ");
            a = b;
            b = next;
        }
    }

    // DYNAMIC PROGRAMMING
    // MEMOIZATION USING HASHMAP
    public static int dynamicFibonacci(int n) {
        return fibonacciHelper(n, new HashMap<>());
    }

    public static int fibonacciHelper(int n, HashMap<Integer, Integer> memo) {
        if (n == 0 || n == 1) {
            return n;
        }

        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        int result = dynamicFibonacci(n - 1) + dynamicFibonacci(n - 2);
        memo.put(n, result);
        return result;
    }

    // MEMOIZATION USING ARRAY
    public static int dynamicFibonacci2(int n) {
        int[] memo = new int[n + 1];

        for (int i = 0; i < memo.length; i++) {
            memo[i] = -1;
        }

        return dynamicFibonacci2(n, memo);
    }

    public static int dynamicFibonacci2(int n, int[] memo) {

        if (n == 1 || n == 2)
            return 1;

        if (memo[n] != -1)
            return memo[n];

        memo[n] = dynamicFibonacci2(n - 1, memo) + dynamicFibonacci2(n - 2, memo);

        return memo[n];
    }
}
