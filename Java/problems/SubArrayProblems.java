package Java.problems;

import java.util.*;

public class SubArrayProblems {
    public static void main(String[] args) {
        int[] nums = { 3, 4, -7, 1, 3, -4, -2, -2 };
        // System.out.println(printAllSubArrays(nums));
        System.out.println(zeroSumSubArray(nums));
    }

    // PRINT ALL SUBARRAYS
    public static List<List<Integer>> printAllSubArrays(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();

        for (int start = 0; start < arr.length; start++) {
            for (int end = start; end < arr.length; end++) {
                List<Integer> subArray = new ArrayList<>();
                for (int k = start; k <= end; k++) {
                    subArray.add(arr[k]);
                }
                result.add(subArray);
            }
        }

        return result;
    }

    // MAXIMUM SUM OF SUBARRAYS
    public static int maxSubArraySum(int[] arr) {
        int currSum = arr[0], maxSum = arr[0];

        for (int i = 1; i < arr.length; i++) {
            currSum = Math.max(currSum, currSum + arr[i]);
            maxSum = Math.max(currSum, maxSum);
        }

        return maxSum;
    }

    // PRINT SUBARRAYS WITH THE SUBARRAY SUM = 0
    public static List<List<Integer>> zeroSumSubArray(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];

                if (sum == 0) {
                    List<Integer> subArray = new ArrayList();
                    for (int k = i; k <= j; k++) {
                        subArray.add(nums[k]);
                    }
                    result.add(subArray);
                }
            }
        }

        return result;
    }
}
