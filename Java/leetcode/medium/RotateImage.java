package Java.leetcode.medium;

import java.util.Arrays;

public class RotateImage {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}}; 
        rotateImage(matrix);
    }

    public static void rotateImage(int[][] matrix){

        int n = matrix.length;

        for(int i = 0 ; i < n ; i++){
            for(int j = i+1 ; j < n ; j++){
                if(i != j){
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }

        int left = 0;
        int right = n - 1;

        for(int row = 0 ; row < n ; row++){
            while (left <= right){
                int temp = matrix[row][left];
                matrix[row][left] = matrix[row][right];
                matrix[row][right] = temp;
                left++;
                right--;
            }
            left = 0;
            right = n-1;
        }

        for(int[] row : matrix){
            for(int x : row){
                System.out.println(x + " ");
            }
        }
    }
}
