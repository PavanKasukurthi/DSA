package Java.leetcode.medium;

public class MinimumSizeSubArraySum {
    public static void main(String[] args) {
        int target = 5;
        int[] nums = {5,2,3,1,1,1,1,1};
        System.out.println(minSizeSubArrayLen(target, nums));
    }

    public static int minSizeSubArrayLen(int target, int[] nums){
        int start = 0, end = 0;
        int window = Integer.MAX_VALUE;
        int currSum = 0;

        for(end = 0; end < nums.length ; end++){
            currSum += nums[end];
            while(currSum >= target){
                window = Math.min(window, end - start + 1);
                currSum -= nums[start];
                start++;
            }
        }

        return (window != Integer.MAX_VALUE) ? window : 0;
    }

    //EXCEEDING TIME LIMIT 
    public static int minSubArrayLen(int target, int[] nums){

          int len = 1;
           
            while(len <= nums.length){
                 int sum = 0;
                for(int i = 0 ; i < len ; i++){
                    sum += nums[i];
                }

                int tempSum = sum;

                for(int i = len ; i < nums.length ; i++){
                    if(tempSum >= target){
                        break;
                    }
                    tempSum = tempSum - nums[i - len] + nums[i];
                }

                if(tempSum >= target){
                    return len;
                }else len += 1;
          }

        return 0;
    }
}
