package Java.algorithms.sorting;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {5,3,7,8,10,12};
        int[] result = insertionSort(arr);
        System.out.println(Arrays.toString(result));
    }

    public static int[] insertionSort(int[] arr){
        for(int i = 1; i < arr.length ; i++){
            int current = arr[i];
            for(int j = i-1 ; j >= 0 && arr[j] > current ; j--){
                arr[j+1] = arr[j];
                arr[j] = current;
            }
        }
        return arr;
    }
}
