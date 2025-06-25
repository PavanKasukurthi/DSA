package Java.leetcode.easy;

// 2278. Percentage of Letter in String
public class PercentageOfLetterInString {
    public static void main(String[] args) {
        String s = "foobar";
        char letter = 'o';
        System.out.println(percentageLetter(s, letter));
    }

    public static int percentageLetter(String s, char letter) {
        int count = 0;
        for (char ch : s.toCharArray()) {
            if (ch == letter)
                count += 1;
        }

        return count * 100 / s.length();
    }
}
