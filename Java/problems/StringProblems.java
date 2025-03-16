package Java.problems;
import java.util.*;

public class StringProblems {
    public static void main(String[] args) {
        // System.out.println(reverseString2("ReverseThisString"));
        // System.out.println(reverseWordsInAString("Reverse this string"));
        // System.out.println(checkRotation("aab", "aba"));
        //System.out.println(nonRepeatingChar("geekforgeeks"));
        String[] strs = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
    }

    /* REVERSE A STRING */
    //USING STRINGBUILDER IN-BUILT FUNCTION
    public static String reverseString(String str){
        StringBuilder reversedString = new StringBuilder(str);
        reversedString.reverse();
        return reversedString.toString();
    }

    //USING TWO POINTER METHOD
    public static String reverseString2(String str){
        int left = 0, right = str.length()-1;
        StringBuilder s = new StringBuilder(str);
        while(left < right){
            char temp = s.charAt(left);
            s.setCharAt(left, s.charAt(right));
            s.setCharAt(right, temp);
            left++;
            right--;
        }

        return s.toString();
    }

    /* REVERSE WORDS IN A GIVEN STRING */
    //USING STRING ARRAY
    public static String reverseWordsInAString(String str){
        String[] words = str.split(" ");
        StringBuilder reversedString = new StringBuilder();
        for(String word : words){
            StringBuilder reversedWord = new StringBuilder(word);
            reversedWord.reverse();
            reversedString.append(reversedWord).append(" ");
        }

        return reversedString.toString();
    }

    /* CHECK FOR ROTATION */
    public static boolean checkRotation(String s1, String s2){
        s1 = s1 + s1;
        return s1.contains(s2) ? true : false;
    }

    /* FIRST NON-REPEATING CHARACTER */
    public static char nonRepeatingChar(String str){
        HashMap<Character, Integer> freqCounter = new HashMap<>();

        for(char ch : str.toLowerCase().toCharArray()){
            freqCounter.merge(ch, 1, Integer::sum);
        }

        for(int i = 0 ; i < str.length() ; i++){
            if(freqCounter.get(str.charAt(i)) == 1) return str.charAt(i);
        }

        return '$';
    }

    /* LONGEST COMMON PREFIX */
    public static String longestCommonPrefix(String[] arr){
        Arrays.sort(arr);
        int count = 0;
        String start = arr[0];
        String end = arr[arr.length - 1];

        for(int i = 0 ; i < start.length() ; i++){
            if(start.charAt(i) == end.charAt(i)) count++;
            else break;
        }

        return start.substring(0, count);
    }

    /* ISOMORPHIC STRINGS */
    public static boolean isomorphicStrings(String s1, String s2){
        if(s1.length() != s2.length()) return false;

        HashMap<Character, Character> hm = new HashMap();

        for(int i = 0 ; i < s1.length() ; i++){
            char charS1 = s1.charAt(i);
            char charS2 = s2.charAt(i);
            if(hm.containsKey(charS1)){
                if(hm.get(charS1) != charS2) return false;
            }
            else {
                if(hm.containsValue(charS2)) return false;
                hm.put(charS1, charS2);
            }
        }
        return true;
    }

    /* IsSubSequence */
    public static boolean isSubsequence(String s, String t){
        if(s.length() == 0 || s.isEmpty()) return true;

        int i = 0, j = 0;

        while(i < s.length() && j < t.length()){
            if(s.charAt(i) == t.charAt(j)){
                i++;
            }
            j++;
        }

        if(i == s.length()) return true;

        return false;
    }  
}
