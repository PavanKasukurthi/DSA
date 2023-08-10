package Java.problems;

// Write a function called maxSubArraySum which accepts an array of integers and a number called n.
// The function should calculate the maximum sum of n consecutive elements in the array.

public class MaxSubArraySum {
    public static void main(String[] args) {

        int[] arr = {1,2,5,2,8,1,5};

        int result = maxSubArraySum(arr, 4);

        if(result == -1) System.out.println("Number is greater than the array length.");

        else System.out.println("The greatest consecutive sum is " + result); 
    }

    public static int maxSubArraySum(int[] arr, int num){

        if(arr.length < num) return -1;

        int maxSum = 0;
        int tempSum = 0;

        for(int i = 0 ; i < num ; i++){
            maxSum += arr[i];
        }

        tempSum = maxSum;

        for(int i = num ; i < arr.length ; i++){
            tempSum = tempSum - arr[i - num] + arr[i];
            maxSum = Math.max(maxSum, tempSum);
        }

        return maxSum;
    }
}