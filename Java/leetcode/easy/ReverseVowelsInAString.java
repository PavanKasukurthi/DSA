package Java.leetcode.easy;

public class ReverseVowelsInAString {
    public static void main(String[] args) {
        System.out.println(reverseVowels("IceCreAm"));
    }

    public static String reverseVowels(String str) {

        char[] word = str.toCharArray();
        int left = 0;
        int right = str.length() - 1;
        String vowels = "aeiouAEIOU";

        while (left < right) {
            while (left < right && vowels.indexOf(word[left]) == -1) {
                left++;
            }
            while (left < right && vowels.indexOf(word[right]) == -1) {
                right--;
            }

            char temp = word[left];
            word[left] = word[right];
            word[right] = temp;

            left++;
            right--;
        }

        String result = new String(word);
        return result;
    }
}
