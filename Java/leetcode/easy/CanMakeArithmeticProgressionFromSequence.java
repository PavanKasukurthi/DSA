package Java.leetcode.easy;

public class CanMakeArithmeticProgressionFromSequence {
    public boolean canMakeArithmeticProgressionFromSequence(int[] nums){
        int diff = nums[1] - nums[0];

        for(int i = 1 ; i < nums.length ; i++){
            if(nums[i] - nums[i-1] != diff) return false;
        }
        
        return true;
    }
}
