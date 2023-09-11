package Java.leetcode.easy;

import java.util.Arrays;

public class NumberOfEmployeesTarget{
    public static void main(String[] args) {
        int[] hours = {0,1,2,3,4};
        int target = 4;
        System.out.println(numberOfEmployeesWhoMetTarget(hours, target));
    }

    public static int numberOfEmployeesWhoMetTarget(int[] employees, int target){
   
        return (int)Arrays.stream(employees).filter(x -> x >= target).count();
       
    }
}