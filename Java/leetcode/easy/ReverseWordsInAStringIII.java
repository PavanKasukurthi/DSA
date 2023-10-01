package Java.leetcode.easy;

import java.util.Arrays;

public class ReverseWordsInAStringIII{
    public static void main(String[] args) {
        System.out.println(reverseWords("Let's take LeetCode contest"));
    }

    public static String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder reversed = new StringBuilder();
        for(String word : words){
            StringBuilder reversedWord = new StringBuilder(word);
            reversedWord.reverse();
            reversed.append(reversedWord).append(" ");
        }

        return reversed.toString().trim();
    }
}