package Java.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class SequentialDigits{
    public static void main(String[] args) {
        System.out.println(sequentialDigits(100, 15000));
    }

    public static List<Integer> sequentialDigits(int low, int high){

        List<Integer> result = new ArrayList<>();

        String number = "123456789";

        for(int i = 0 ; i < number.length() ; i++){
            for(int j = i+1 ; j <= number.length() ; j++){
                int num = Integer.parseInt(number.substring(i, j));
                if(num >= low && num <= high) result.add(num);
            }
        }

        result.sort(null);

        return result;
    }
}