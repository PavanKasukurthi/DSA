package Java.leetcode.medium;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReverseWordsInAString {
    public static void main(String[] args) {
        System.out.println(reverseWords("hello world!"));
    }

    //USING BUILTIN METHODS
    public static String reverseWords(String s){
        s = s.trim();
        List<String> wordList = Arrays.asList(s.split("\\s+"));
        Collections.reverse(wordList);
        return String.join(" ", wordList);
    }

}
