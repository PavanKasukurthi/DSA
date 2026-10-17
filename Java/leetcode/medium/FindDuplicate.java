package Java.leetcode.medium;

import java.util.Arrays;

public class FindDuplicate {
  public static void main(String[] args) {
    int[] nums = { 1, 3, 4, 2, 1 };
    System.out.println(findDuplicate2(nums));
  }

  public static int findDuplicate(int[] nums) {
    Arrays.sort(nums);

    for (int i = 0; i < nums.length - 1; i++) {
      if (nums[i] == nums[i + 1]) {
        return nums[i];
      }
    }
    return -1;
  }

  // USING CYCLE SORT
  public static int findDuplicate2(int[] nums) {
    int i = 0;
    while (i < nums.length) {
      if (nums[i] != i + 1) {
        int correctIndex = nums[i] - 1;
        if (nums[i] != nums[correctIndex]) {
          swap(nums, i, correctIndex);
        } else {
          return nums[i];
        }
      }
      else{
        i++;
      }
    }
    return -1;
  }

  private static void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }
}