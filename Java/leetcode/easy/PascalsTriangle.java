package Java.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle{
    public static void main(String[] args) {
        System.out.println(pascalsTriangle(5));
    }

    public static List<List<Integer>> pascalsTriangle(int numRows){
        List<List<Integer>> triangle = new ArrayList<>();

        if(numRows == 0) return triangle;

        List<Integer> first_row = new ArrayList<>();
        first_row.add(1);
        triangle.add(first_row);

        for(int i = 1 ; i < numRows ; i++){
            List<Integer> prev_row = triangle.get(i-1);
            List<Integer> curr_row = new ArrayList<>();

            curr_row.add(1);

            for(int j = 1 ; j < i ; j++){
                curr_row.add(prev_row.get(j) + prev_row.get(j-1));
            }

            curr_row.add(1);

            triangle.add(curr_row);
        }

        return triangle;
    }
}