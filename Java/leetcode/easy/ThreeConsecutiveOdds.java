package Java.leetcode.easy;

public class ThreeConsecutiveOdds {
    public static void main(String[] args) {
        int[] nums = { 2, 6, 4, 1 };
        System.out.println(threeConsecutiveOdds(nums));
    }

    public static boolean threeConsecutiveOdds(int[] nums) {
        if (nums.length < 3)
            return false;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 != 0) {
                count++;
                if (count == 3)
                    return true;
            } else if (nums[i] % 2 == 0) {
                count = 0;
            }
        }
        return false;
    }
}
