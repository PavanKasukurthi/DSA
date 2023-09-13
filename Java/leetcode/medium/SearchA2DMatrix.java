package Java.leetcode.medium;

public class SearchA2DMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}}; 
        int target = 3;
        System.out.println(searchMatrix(matrix, target));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;
        int col = 0;

        while(row < matrix.length ){
            int start = 0;
            int end = matrix[col].length - 1;
            while(start <= end){
                int mid = start + (end - start)/2;
                if(matrix[row][mid] == target) return true;
                if(matrix[row][mid] < target) start = mid + 1;
                else end = mid - 1;
            }
            row++;
            col++;
        }
        return false;
    }
}
