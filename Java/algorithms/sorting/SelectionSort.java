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

    public static void selectionSort2(int[] arr){
        for(int i = 0 ; i < arr.length ; i++){
            int lastIndex = arr.length - i - 1;
            int maxIndex = getMax(arr, 0 , last);

            swap(arr, maxIndex, lastIndex);
        }
    }

    public static void swap(int[] arr, int first, int last){
        int temp = arr[first];
        arr[first] = arr[last];
        arr[last] = temp;
    }

    public static int getMaxIndex(int[] arr, int start, int last){
        int max = start;
        for(int i = start, i <= last ; i++){
            if(arr[max] < arr[i]){
                max = i;
            }
        }
        return max;
    }
}

