package Java.leetcode.easy;

public class FindNumbersWithEvenNoOfDigits {
    public static void main(String[] args) {
        int[] nums = { 12, 345, 2, 6, 7896 };

        System.out.println(findNumbers(nums));
    }

    public static int findNumbers(int[] nums) {
        int count = 0;
        for (int n : nums) {
            if (hasEvenDigits(n))
                count++;
        }
        return count;
    }

    public static boolean hasEvenDigits(int num) {
        int digitCount = 0;
        while (num != 0) {
            digitCount += 1;
            num = num / 10;
        }
        return digitCount % 2 == 0 ? true : false;
    }
}
