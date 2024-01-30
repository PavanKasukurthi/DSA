package Java.problems;

import java.util.HashMap;

public class Fibonacci {
    
    public static void main(String[] args) {
        System.out.println(dynamicFibonacci2(4));
    }
    //Recursive approach
    public static int fibonacci(int n){
        if(n == 1 || n == 2) return 1;

        else return fibonacci(n-1) + fibonacci(n-2);
    }

    //DYNAMIC PROGRAMMING
    //MEMOIZATION USING HASHMAP
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

    //MEMOIZATION USING ARRAY
    public static int dynamicFibonacci2(int n){
        int[] memo = new int[n+1];

        for(int i = 0 ; i < memo.length ; i++){
            memo[i] = -1;
        }

        return dynamicFibonacci2(n, memo);
    }

    public static int dynamicFibonacci2(int n, int[] memo){

        if(n == 1 || n == 2) return 1;

        if(memo[n] != -1) return memo[n];

        memo[n] = dynamicFibonacci2(n-1, memo) + dynamicFibonacci2(n-2, memo);

        return memo[n];
    }
}
