package Java.problems;

import java.util.HashMap;

public class Anagram {
    public static void main(String[] args) {
        System.out.println(anagram("cinema", "icemaa"));
    }

    public static boolean anagram(String str1, String str2) {

        if (str1.length() != str2.length())
            return false;

        char[] arr1 = str1.toLowerCase().toCharArray();
        char[] arr2 = str2.toLowerCase().toCharArray();

        HashMap<Character, Integer> frequencyCounter1 = new HashMap<>();
        HashMap<Character, Integer> frequencyCounter2 = new HashMap<>();

        for (Character ch : arr1) {
            frequencyCounter1.merge(ch, 1, Integer::sum);
        }

        for (Character ch : arr2) {
            frequencyCounter2.merge(ch, 1, Integer::sum);
        }

        if (!(frequencyCounter1.equals(frequencyCounter2)))
            return false;

        return true;
    }
}
