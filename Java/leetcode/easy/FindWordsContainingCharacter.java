package Java.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class FindWordsContainingCharacter {
    public static void main(String[] args) {
        String[] words = {"leet","code"};
        char x = 'e';
        System.out.println(findWordsContaining(words, x));
    }

    public static List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> result = new ArrayList();
        for (int i = 0; i < words.length; i++) {
            if (words[i].contains(String.valueOf(x))) {
                result.add(i);
            }
        }
        return result;
    }
}
