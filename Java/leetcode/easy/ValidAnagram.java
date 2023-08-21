package Java.leetcode.easy;

import java.util.HashMap;

public class ValidAnagram{
    public static void main(String[] args) {
        System.out.println(validAnagram("anagram", "nagaram"));
    }

    public static boolean validAnagram(String s, String t){

        if(s.length() != t.length()) return false;

        char[] arr1 = s.toLowerCase().toCharArray();
        char[] arr2 = t.toLowerCase().toCharArray();

        HashMap<Character, Integer> frequencyCounter1 = new HashMap<>();
        HashMap<Character, Integer> frequencyCounter2 = new HashMap<>();

        for(Character ch : arr1){
            frequencyCounter1.merge(ch, 1, Integer::sum);
        }

        for(Character ch : arr2){
            frequencyCounter2.merge(ch, 1, Integer::sum);
        }

        if(!(frequencyCounter1.equals(frequencyCounter2))) return false;

        return true;
    }
}