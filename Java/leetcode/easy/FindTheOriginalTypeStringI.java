package Java.leetcode.easy;

// 3330. Find the Original Typed String I
public class FindTheOriginalTypeStringI {
    public static void main(String[] args) {
        System.out.println(possibleStringCount("abbcccc"));
    }

    public static int possibleStringCount(String word) {
        int result = 1;
        for (int i = 1; i < word.length(); i++) {
            if (word.charAt(i - 1) == word.charAt(i)) {
                result++;
            }
        }
        return result;
    }
}