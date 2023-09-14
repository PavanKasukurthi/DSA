package Java.leetcode.medium;

public class FindPeakElement {
    public static void main(String[] args) {
        int[] nums = {1,5,2,3,5,1};
        System.out.println(findPeakElement(nums));
    }
    public static int findPeakElement(int[] nums){
        int start = 0;
        int end = nums.length - 1;

        while(start < end){
            int mid = start + (end - start) / 2;
            if(nums[mid] > nums[mid + 1]){
                end = mid;
            }else{
                start = mid + 1;
            }
        }

        return start;
    }
}
