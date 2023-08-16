package Java.algorithms.sorting;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {4, 6,1, 2, 10, 7, 8, 11, 3, 16};
        int[] result = selectionSort(arr);
        System.out.println(Arrays.toString(result));
    }

    public static int[] selectionSort(int[] arr){

        for(int i = 0 ; i < arr.length-1 ; i++){
            int min = i;
            for(int j = i+1 ; j < arr.length ; j++){
                if(arr[j] < arr[min]) {
                    min = j;
                }
            }
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }
}

