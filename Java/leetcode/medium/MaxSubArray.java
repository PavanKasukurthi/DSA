package Java.leetcode.medium;

public class MaxSubArray {
    public static void main(String[] args) {
    //    int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int[] nums = {5,4,-1,7,8};
       System.out.println(maxSubArraySum(nums));
    }

    //KADANE'S ALGORITHM
    public static int maxSubArraySum(int[] arr){
        int maxSum = arr[0];
        int currSum = maxSum;

        for(int i = 1; i < arr.length ; i++){
            currSum = Math.max(arr[i], arr[i] + currSum);
            maxSum = Math.max(currSum, maxSum);
        }

        return maxSum;
    }
}
