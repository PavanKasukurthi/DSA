package Java.leetcode.easy;

public class MinimumCommonValue {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3};
        int[] nums2 = {2,4};
        System.out.println(getCommon(nums1, nums2));
    }   
    
    public static int getCommon(int[] nums1, int[] nums2){

        int i = 0, j = 0;

        while(i < nums1.length && j < nums2.length){
            if(nums1[i] == nums2[j]) return nums1[i];
            else if(nums1[i] < nums2[j]) i++;
            else if(nums1[i] > nums2[j]) j++;
        }

        return -1;
    }
}
