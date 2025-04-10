package Java.problems;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StringProblems {
    public static void main(String[] args) {
        // System.out.println(reverseString2("ReverseThisString"));
        // System.out.println(reverseWordsInAString("Reverse this string"));
        // System.out.println(checkRotation("aab", "aba"));
        // System.out.println(nonRepeatingChar("geekforgeeks"));
        // String[] strs = {"flower","flow","flight"};
        // System.out.println(longestCommonPrefix(strs));
        // System.out.println(longestSubstringWithoutRepeatingCharacters("pwwkew"));
        // System.out.println(expandString("a2b5c3"));
        // frequencyOfCharacters("operations");
        System.out.println(removeConsecutiveVowels("geek for geeks"));
    }

    /* PALINDROME */
    public static boolean isPalindrome(String str) {
        int left = 0, right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    public static boolean isPalindromeStreams(String str) {
        return IntStream.range(0, str.length() / 2)
                .allMatch(c -> str.charAt(c) == str.charAt(str.length() - 1 - c));
    }

    /* REVERSE A STRING */
    // USING STRINGBUILDER IN-BUILT FUNCTION
    public static String reverseString(String str) {
        StringBuilder reversedString = new StringBuilder(str);
        reversedString.reverse();
        return reversedString.toString();
    }

    // USING TWO POINTER METHOD
    public static String reverseString2(String str) {
        int left = 0, right = str.length() - 1;
        StringBuilder s = new StringBuilder(str);
        while (left < right) {
            char temp = s.charAt(left);
            s.setCharAt(left, s.charAt(right));
            s.setCharAt(right, temp);
            left++;
            right--;
        }

        return s.toString();
    }

    // STRING REVERSAL USING STREAMS
    public static String reverseStringUsingStreams(String str) {
        return IntStream.range(0, str.length())
                .map(i -> str.length() - 1 - i)
                .mapToObj(str::charAt)
                .map(String::valueOf)
                .collect(Collectors.joining());
    }

    /* REVERSE WORDS IN A GIVEN STRING */
    // USING STRING ARRAY
    public static String reverseWordsInAString(String str) {
        String[] words = str.split(" ");
        StringBuilder reversedString = new StringBuilder();
        for (String word : words) {
            StringBuilder reversedWord = new StringBuilder(word);
            reversedWord.reverse();
            reversedString.append(reversedWord).append(" ");
        }

        return reversedString.toString();
    }

    /* CHECK FOR ROTATION */
    public static boolean checkRotation(String s1, String s2) {
        s1 = s1 + s1;
        return s1.contains(s2) ? true : false;
    }

    /* FIRST NON-REPEATING CHARACTER */
    public static char nonRepeatingChar(String str) {
        HashMap<Character, Integer> freqCounter = new HashMap<>();

        for (char ch : str.toLowerCase().toCharArray()) {
            freqCounter.merge(ch, 1, Integer::sum);
        }

        for (int i = 0; i < str.length(); i++) {
            if (freqCounter.get(str.charAt(i)) == 1)
                return str.charAt(i);
        }

        return '$';
    }

    /* FIRST NON-REPEATING CHARACTER IN A STRING USING STREAMS */
    public static char firstNonRepeatingChar(String str) {

        return str.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);

    }

    /* LONGEST COMMON PREFIX */
    public static String longestCommonPrefix(String[] arr) {
        Arrays.sort(arr);
        int count = 0;
        String start = arr[0];
        String end = arr[arr.length - 1];

        for (int i = 0; i < start.length(); i++) {
            if (start.charAt(i) == end.charAt(i))
                count++;
            else
                break;
        }

        return start.substring(0, count);
    }

    /* ISOMORPHIC STRINGS */
    public static boolean isomorphicStrings(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;

        HashMap<Character, Character> hm = new HashMap();

        for (int i = 0; i < s1.length(); i++) {
            char charS1 = s1.charAt(i);
            char charS2 = s2.charAt(i);
            if (hm.containsKey(charS1)) {
                if (hm.get(charS1) != charS2)
                    return false;
            } else {
                if (hm.containsValue(charS2))
                    return false;
                hm.put(charS1, charS2);
            }
        }
        return true;
    }

    /* IsSubSequence */
    public static boolean isSubsequence(String s, String t) {
        if (s.length() == 0 || s.isEmpty())
            return true;

        int i = 0, j = 0;

        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }

        if (i == s.length())
            return true;

        return false;
    }

    /* LONGEST SUBSTRING WITHOUT REPEATING CHARACTERS */
    public static int longestSubstringWithoutRepeatingCharacters(String str) {
        int i = 0, j = 0, max = 0;

        HashSet<Character> set = new HashSet<>();

        while (j < str.length()) {
            if (!set.contains(str.charAt(j))) {
                set.add(str.charAt(j));
                j++;
                max = Math.max(max, set.size());
            } else {
                set.remove(str.charAt(i));
                i++;
            }
        }
        return max;
    }

    // EXPAND STRING a2b3c4 -> aabbbcccc
    public static String expandString(String str) {
        StringBuilder result = new StringBuilder();
        char prevChar = '\0'; // To store the previous character

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (Character.isLetter(ch)) {
                prevChar = ch; // Store the letter
            } else if (Character.isDigit(ch) && prevChar != '\0') {
                int count = ch - '0'; // Convert character digit to integer
                for (int j = 0; j < count; j++) {
                    result.append(prevChar);
                }
            }
        }

        return result.toString();
    }

    // FREQUENCY OF CHARACTERS USING JAVA 8
    public static void frequencyOfCharacters(String str) {
        Map<Character, Long> charFreq = str.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        System.out.println(charFreq);
    }

    // REMOVE CONSECUTIVE VOWELS
    public static String removeConsecutiveVowels(String str) {

        StringBuilder result = new StringBuilder();
        result.append(str.charAt(0));

        for (int i = 1; i < str.length(); i++) {
            if (!isVowel(str.charAt(i - 1)) || !isVowel(str.charAt(i))) {
                result.append(str.charAt(i));
            }
        }

        return result.toString();
    }

    public static boolean isVowel(char c) {
        return (c == 'a') || (c == 'e') || (c == 'i') || (c == 'o') || (c == 'u');
    }

    // VALID PARANTHESIS
    public static boolean isValidUsingStack(String str) {
        if (str.length() % 2 != 0)
            return false;

        Stack<Character> stack = new Stack<>();

        for (char c : str.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            } else if (c == ']' && !stack.isEmpty() && stack.peek() == '[') {
                stack.pop();
            } else if (c == '}' && !stack.isEmpty() && stack.peek() == '{') {
                stack.pop();
            } else
                return false; // For edge cases like ([}}])
        }

        return stack.isEmpty(); // When every pair is removed then stack becomes empty and it is true, else
                                // false
    }
}
