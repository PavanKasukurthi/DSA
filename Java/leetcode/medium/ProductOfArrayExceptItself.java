package Java.leetcode.medium;

import java.util.Arrays;

public class ProductOfArrayExceptItself{
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        System.out.println(Arrays.toString(productOfArrayExceptItself(arr)));
    }

    public static int[] productOfArrayExceptItself(int[] arr){

        int[] result = new int[arr.length];

        result[0] = 1;
        for(int i = 1 ; i < arr.length ; i++){
            result[i] = result[i-1] * arr[i-1];
        }

        int R = 1;
        for(int i = arr.length-1 ; i >=0 ; i--){
            result[i] =  result[i] * R;
            R = R * arr[i];
        }

        return result;
    }
}