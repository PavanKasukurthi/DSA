package Java.leetcode.easy;

import java.util.HashMap;

public class RansomNote {
    public static void main(String[] args) {
        String ransomNote = "aac", magazine = "aab";
        System.out.println(canConstruct(ransomNote, magazine));
    }

    public static boolean canConstruct(String ransomNote, String magazine){

        HashMap<Character, Integer> frequencyCounter1 = new HashMap<>();
        HashMap<Character, Integer> frequencyCounter2 = new HashMap<>();

        char[] a = ransomNote.toCharArray();
        char[] b = magazine.toCharArray();

        for(char ch : a){
           frequencyCounter1.merge(ch, 1, Integer::sum);
        }

        for(char ch : b){
           frequencyCounter2.merge(ch, 1, Integer::sum);
        }

        for (char ch : frequencyCounter1.keySet()) {
            if (!frequencyCounter2.containsKey(ch) || frequencyCounter1.get(ch) > frequencyCounter2.get(ch)) {
                return false;
            }
        }

        return true;
    }
}
