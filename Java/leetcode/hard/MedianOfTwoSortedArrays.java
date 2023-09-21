package Java.leetcode.hard;

public class MedianOfTwoSortedArrays {
    
    public static void main(String[] args) {
        int[] nums1 = {1,3};
        int[] nums2 = {2};

        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

     public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] mix = new int[nums1.length + nums2.length];

        int i = 0, j = 0, k = 0;

        while(i < nums1.length && j < nums2.length){
            if(nums1[i] < nums2[j]){
                mix[k] = nums1[i++];
            }else{
                mix[k] = nums2[j++];
            }
            k++;
        }

        while(i < nums1.length){
            mix[k++] = nums1[i++];
        }

        while(j < nums2.length){
            mix[k++] = nums2[j++];
        }

        if(mix.length % 2 == 0){
            return (double)(mix[mix.length/2] + mix[(mix.length/2) - 1])/2;
        }

        return (double)mix[mix.length/2];
    }
}
