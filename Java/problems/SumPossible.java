package Java.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SumPossible {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);

        System.out.println(sumPossible(4, numbers));
    }

    //RECURSION
    public static boolean sumPossible(int amount, List<Integer> numbers){

        if(amount == 0) return true;
        if(amount < 0) return false;

        for(int n : numbers){
            int subAmount = amount - n;
            if(sumPossible(subAmount, numbers)){
                return true;
            }
        }

        return false;
    }

    //DYNAMIC PROGRAMMING

    public static boolean dynamicSumPossible(int amount, List<Integer> numbers){
        return dynamicSumPossible(amount, numbers, new HashMap<>());
    }

    public static boolean dynamicSumPossible(int amount, List<Integer> numbers, HashMap<Integer, Boolean> memo){

        if(amount == 0) return true;
        if(amount < 0) return false;

        if(memo.containsKey(amount)) return memo.get(amount);
        
        for(int n : numbers){
            int subAmount = amount - n;
            if(dynamicSumPossible(subAmount, numbers, memo)){
                memo.put(amount, true);
                return true;
            }
        }

        memo.put(amount, false);
        return false;
    }
}
