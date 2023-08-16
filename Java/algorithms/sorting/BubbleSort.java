package Java.algorithms.sorting;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr= {6,3,8,21, 11, 5, 7};
        int[] result = bubbleSortOptimized(arr);
        System.out.println(Arrays.toString(result));
    }

    public static int[] bubbleSort(int[] arr){
        for(int i = 0 ; i < arr.length ; i++){
            for(int j = 0 ; j < arr.length-1 ; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        return arr;
    }

    public static int[] bubbleSortOptimized(int[] arr) {
        for(int i = arr.length ; i > 0 ; i--){
            Boolean noSwaps = true;
            for(int j = 0 ; j < i-1 ; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    noSwaps = false;
                }
            }
            if(noSwaps == true) break;
        }
        return arr;
    }
}
