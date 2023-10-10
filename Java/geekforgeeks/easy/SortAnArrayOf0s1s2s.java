package Java.geekforgeeks.easy;

import java.util.Arrays;

public class SortAnArrayOf0s1s2s {
    public static void main(String[] args) {
        int arr[]= {0, 2, 1, 2, 0};
       sort012(arr, 5);
       System.out.println(Arrays.toString(arr));
    }

    public static void sort012(int a[], int n){
        int start = 0;
        int end = a.length - 1;
        int index = 0;

        while(index <= end && start < end){
            if(a[index] == 0){
                a[index] = a[start];
                a[start] = 0;
                index++;
                start++;
            }
            else if(a[index] == 2){
                a[index] = a[end];
                a[end] = 2;
                end--;
            }
            else{
                index++;
            }
        }
    }
}
