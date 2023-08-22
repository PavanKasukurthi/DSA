package Java.leetcode.easy;

import java.util.Arrays;

public class MergeSortedArray{
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = {2,5,6};
        int n = 3;
        merge(nums1, m, nums2, n);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
 
        for(int j = 0, i = m ; j < n ; j++){
            nums1[i++] = nums2[j];
        }

        insertionSort(nums1);

        System.out.println(Arrays.toString(nums1));
    }

    public static int[] insertionSort(int[] arr){

        for(int i = 1 ; i < arr.length ; i++){
            int currentValue = arr[i];
            for(int j = i-1 ; j >=0 && arr[j] > currentValue ; j--){
                arr[j+1] = arr[j];
                arr[j] = currentValue; 
            }
        }

        return arr;
    }
}