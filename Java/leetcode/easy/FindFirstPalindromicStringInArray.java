package Java.leetcode.easy;

public class FindFirstPalindromicStringInArray{
    public static void main(String[] args) {
        String[] words = {"abc","car","ada","racecar","cool"};
        System.out.println(firstPalindrome(words));
    }

    public static String firstPalindrome(String[] words) {
        for(String word : words){
            if(isPalindrome(word, 0, word.length()-1)) return word;
        }
        return "";
    }

    public static boolean isPalindrome(String word, int left, int right){
        while(left < right){
            if(word.charAt(left) != word.charAt(right)) return false;
            left++;
            right--;
        }

        return true;
    }
}