package Java.problems;

import java.util.HashMap;

public class Tribonacci {
    public static void main(String[] args) {
        System.out.println(tribonacci(5));
        System.out.println(tribonacci2(5));
    }

    //RECURSION
    public static int tribonacci(int n){
        if(n == 0 || n == 1) return 0;
        if(n == 2) return 1;

        return tribonacci(n-1) + tribonacci(n-2) + tribonacci(n-3);
    }

    //DYNAMIC PROGRAMMING
    public static int tribonacci2(int n){
        return dynamicTribonacci(n, new HashMap<>());
    }

    public static int dynamicTribonacci(int n, HashMap<Integer, Integer> memo){

        if(n == 0 || n == 1) return 0;
        if(n == 2) return 1;

        if(memo.containsKey(n)) return memo.get(n);

        int result = dynamicTribonacci(n-1, memo) + dynamicTribonacci(n-2, memo) + dynamicTribonacci(n-3, memo);

        memo.put(n, result);

        return result;
    }
}
