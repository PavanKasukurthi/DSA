package Java.leetcode.easy;

import java.util.Arrays;

public class RichestCustomerWealth {
    public static void main(String[] args) {
        int[][] accounts = {{1,2,3},{3,2,1}};
        System.out.println(richestCustomer(accounts));
    }

    //BRUTE FORCE
    public static int richestCustomerWealth(int[][] accounts){

        int row = accounts.length;
        int col = accounts[0].length;
        int[] wealths = new int[row];

        for(int i = 0 ; i < row ; i++){
               int sum = 0;
            for(int j = 0 ; j < col ; j++){
                sum += accounts[i][j];
            }
            wealths[i] = sum;
        }

        Arrays.sort(wealths);

        return wealths[wealths.length - 1];
    }

    //OPTIMIZED
    public static int richestCustomer(int[][] accounts){

        int max = Integer.MIN_VALUE;
        for(int[] arr: accounts){
            int sum = 0;
            for(int a: arr){
                sum+= a;
            }
            max = Math.max(max, sum);
        }
        return max;
    }
}

