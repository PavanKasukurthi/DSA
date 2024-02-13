package Java.leetcode.easy;

import java.util.HashMap;

public class FirstUniqChar {
    
    public static void main(String[] args) {
        String s = "loveleetcode";
        System.out.println(firstUniqChar(s));
    }

    public static int firstUniqChar(String s) {
        HashMap<Character, Integer> freqCounter = new HashMap<>();

        for(char ch : s.toLowerCase().toCharArray()){
            freqCounter.merge(ch, 1, Integer::sum);
        }

        for(int i = 0 ; i < s.length() ; i++){
            if(freqCounter.get(s.charAt(i)) == 1) return i;
        }

        return -1;
    }
}
