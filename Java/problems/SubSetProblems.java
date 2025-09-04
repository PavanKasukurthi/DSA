package Java.problems;

import java.util.*;

public class SubSetProblems {

    public static void main(String[] args) {
        int[] arr = { 5, 6, 11, 5 };
        int[] nums = { 1, -1, 2, -2, 3 };
        List<List<Integer>> result = new ArrayList<>();

        // findSubsets(arr, 0, new ArrayList<>(), result);
        zeroSumSubSets(nums, 0, new ArrayList<>(), 0, result);

        System.out.println(result);
    }

    public static void findSubsets(int[] arr, int index, ArrayList<Integer> current, List<List<Integer>> result) {
        if (index == arr.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        current.add(arr[index]);
        findSubsets(arr, index + 1, current, result);
        current.remove(current.size() - 1);
        findSubsets(arr, index + 1, current, result);
    }

    public static void zeroSumSubSets(int[] arr, int index, ArrayList<Integer> current, int sum,
            List<List<Integer>> result) {
        if (index == arr.length) {

            if (sum == 0 && !current.isEmpty()) {
                result.add(new ArrayList<>(current));
            }
            return;
        }

        current.add(arr[index]);
        zeroSumSubSets(arr, index + 1, current, sum + arr[index], result);
        current.remove(current.size() - 1);
        zeroSumSubSets(arr, index + 1, current, sum, result);
    }
}
