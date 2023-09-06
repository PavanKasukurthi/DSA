package Java.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    //ASKED IN INTERVIEW
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};

        System.out.println(spiralMatrix(matrix));
    }

    public static List<Integer> spiralMatrix(int[][] nums){

        int rBegin = 0;
        int cBegin = 0;
        int rEnd = nums.length-1;
        int cEnd = nums[0].length-1;

        List<Integer> result = new ArrayList<>();

        while(rBegin <= rEnd && cBegin <= cEnd){

            for(int i = cBegin ; i <= cEnd ; i++){
                result.add(nums[rBegin][i]);
            }

            rBegin++;

            for(int i = rBegin ; i <= rEnd ; i++){
                result.add(nums[i][cEnd]);
            }

            cEnd--;

            if(rBegin <= rEnd){
                for(int i = cEnd ; i >= cBegin ; i--){
                    result.add(nums[rEnd][i]);
                }
            }

            rEnd--;

            if(cBegin <= cEnd){
                for(int i = rEnd ; i >= rBegin ; i--){
                    result.add(nums[i][cBegin]);
                }
            }

            cBegin++;
        }

        return result;
    }
}
