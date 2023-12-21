package Java.leetcode.medium;

import java.util.Arrays;

public class WidestVerticalAreaBetweenTwoPoints {
     public int maxWidthOfVerticalArea(int[][] points) {
        int[] arr = new int[points.length];
        for(int i = 0 ; i < points.length ; i++){
            arr[i] = points[i][0];
        }

        Arrays.sort(arr);

        int max = Math.abs(arr[0] - arr[1]);
        for(int i = 2; i < arr.length ; i++){
            max = Math.max(max, Math.abs(arr[i] - arr[i-1]));
        }

        return max;
    }

    //IN PLACE
    public int maxWidthOfVerticalArea1(int[][] points){

        int max = 0;
        Arrays.sort(points, (a,b) -> Integer.compare(a[0], b[0]));

        for(int i = 1 ; i < points.length ; i++){
            max = Math.max(max, points[i][0] - points[i-1][0]);
        }

        return max;
    }
}
