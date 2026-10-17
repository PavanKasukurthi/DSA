package Java.leetcode.easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class FindAllNumbersDisappearedInArray {

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        FindAllNumbersDisappearedInArray solution = new FindAllNumbersDisappearedInArray();
        System.out.println(solution.findDisappearedNumbers2(nums));
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        int len = nums.length;
        ArrayList<Integer> result = new ArrayList<>();

        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        while (len > 0) {
            if (!set.contains(len))
                result.add(len);

            len--;
        }

        return result;
    }

    // USING CYCLE SORT
    public List<Integer> findDisappearedNumbers2(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int i = 0;
        while (i < nums.length) {
            int correctIndex = nums[i] - 1;
            if (nums[i] != nums[correctIndex]) {
                swap(nums, i, correctIndex);
            } else {
                i++;
            }
        }

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] - 1 != j) {
                result.add(j + 1);
            }
        }

        return result;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
