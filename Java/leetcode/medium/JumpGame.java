package Java.leetcode.medium;

public class JumpGame {

    public static void main(String[] args) {
        int[] nums = {0,3,1,1,4};
        System.out.println(jumpGame(nums));
    }
    
    public static boolean jumpGame(int[] nums){
        if(nums.length == 1 || nums[0] >= nums.length-1) return true;
        if(nums[0] == 0) return false;

        int lastIndex = nums.length - 1;
        for(int i = nums.length-1 ; i >= 0 ; i--){
            if(i + nums[i] >= lastIndex){
                lastIndex = i;
            }
        }

        return lastIndex == 0 ? true : false;
    }
}
