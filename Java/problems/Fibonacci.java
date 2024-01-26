package Java.problems;

import java.util.HashMap;

public class Fibonacci {
    
    public static void main(String[] args) {
        System.out.println(dynamicFibonacci(5));
    }
    //Recursive approach
    public static int fibonacci(int n){
        if(n == 1 || n == 2) return 1;

        else return fibonacci(n-1) + fibonacci(n-2);
    }

    //DYNAMIC PROGRAMMING
    //MEMOIZATION
    public static int dynamicFibonacci(int n){
       return fibonacciHelper(n, new HashMap<>());
    }

    public static int fibonacciHelper(int n, HashMap<Integer, Integer> memo){
        if(n == 0 || n == 1){
            return n;
        }

        if(memo.containsKey(n)){
            return memo.get(n);
        }

        int result = dynamicFibonacci(n-1) + dynamicFibonacci(n-2);
        memo.put(n, result);
        return result;
    }
}
