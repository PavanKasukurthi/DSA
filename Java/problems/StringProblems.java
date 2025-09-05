package Java.problems;

import java.util.*;
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
        // System.out.println(removeConsecutiveVowels("geek for geeks"));
        // characterFrequency("nzcxfxv");
        // stringSwap("First", "Second");
        // System.out.println(reverseStringUsingStreams("abcd"));
        // percentageOfChars("Tiger Runs @ The Speed Of 100 km/hour.");
        System.out.println(firstNonRepeatingCharWithoutHashMap("aaaadddeeeeferrrrrr"));
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
        return str.chars().mapToObj(c -> (char) c)
                .collect(Collectors.collectingAndThen(
                        Collectors.toList(),
                        list -> {
                            Collections.reverse(list);
                            return list.stream()
                                    .map(String::valueOf)
                                    .collect(Collectors.joining());
                        }));
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

    public static char firstNonRepeatingCharWithoutHashMap(String str) {
        int[] freq = new int[26]; // a-z

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            freq[ch - 'a']++;
        }

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (freq[ch - 'a'] == 1) {
                return ch;
            }
        }

        return '\0';
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

    public static String longestSubstringWithoutRepeatingCharacters2(String str) {
        int j = 0, max = 0, start = 0;

        HashSet<Character> set = new HashSet<>();

        for (int i = 0; i < str.length(); i++) {
            if (!set.contains(str.charAt(i))) {
                set.add(str.charAt(i));

                if (set.size() > max) {
                    max = set.size();
                    start = j;
                }
            } else {
                set.remove(str.charAt(j));
                j++;
            }
        }

        return str.substring(start, start + max);
    }

    // EXPAND STRING a2b3c4 -> aabbbcccc
    public static String expandString(String str) {
        StringBuilder result = new StringBuilder();
        char prevChar = '\0'; // To store the previous character

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (Character.isLetter(ch)) {
                prevChar = ch; // Store the letter
                result.append(ch);
            } else if (Character.isDigit(ch) && prevChar != '\0') {
                int count = ch - '0'; // Convert character digit to integer
                for (int j = 1; j < count; j++) {
                    result.append(prevChar);
                }
            }
        }

        return result.toString();
    }

    // STRING COMPRESSION
    public static String stringCompression(String str) {
        if (str == null || str.isEmpty())
            return str;

        StringBuilder result = new StringBuilder();
        int count = 1;

        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == str.charAt(i - 1)) {
                count++;
            } else {
                result.append(str.charAt(i - 1)).append(count);
                count = 1;
            }
        }
        result.append(str.charAt(str.length() - 1)).append(count);

        return result.length() < str.length() ? result.toString() : str;
    }

    // FREQUENCY OF CHARACTERS USING JAVA 8
    public static void frequencyOfCharacters(String str) {
        Map<Character, Long> charFreq = str.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        System.out.println(charFreq);
    }

    // REMOVE CONSECUTIVE VOWELS
    public static boolean isVowel(char c) {
        return (c == 'a') || (c == 'e') || (c == 'i') || (c == 'o') || (c == 'u');
    }

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

    public static String removeConsecutiveVowelsUsingStreams(String str) {
        StringBuilder result = new StringBuilder();
        result.append(str.charAt(0));

        IntStream.range(1, str.length())
                .filter(c -> !isVowel(str.charAt(c - 1)) || !isVowel(str.charAt(c)))
                .forEach(c -> result.append(str.charAt(c)));

        return result.toString();
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

    // CHARACTER FREQUENCY WITHOUT USING HASHMAP
    public static void characterFrequency(String str) {
        int[] freq = new int[256];

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            freq[ch]++;
        }

        // System.out.println(Arrays.toString(freq));

        boolean[] printed = new boolean[256];

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (!printed[ch]) {
                System.out.println(ch + " : " + freq[ch]);
                printed[ch] = true;
            }
        }
    }

    // Swapping two strings without using a temp variable and special methods
    public static void stringSwap(String str1, String str2) {
        str1 = str1 + str2;
        str2 = str1.substring(0, str1.length() - str2.length());
        str1 = str1.substring(str2.length());

        System.out.println("Str1: " + str1);
        System.out.println("Str2: " + str2);
    }

    // Find The Percentage Of Uppercase Letters, Lowercase Letters, Digits And Other
    // Special Characters In A String
    public static void percentageOfChars(String str) {
        int lowerCase = 0, upperCase = 0, digits = 0, specialChars = 0;

        for (char ch : str.toCharArray()) {
            if (Character.isDigit(ch)) {
                digits++;
            } else if (Character.isLowerCase(ch)) {
                lowerCase++;
            } else if (Character.isUpperCase(ch)) {
                upperCase++;
            } else {
                specialChars++;
            }
        }

        int lowerCasePercentage = lowerCase * 100 / str.length();
        int upperCasePercentage = upperCase * 100 / str.length();
        int digitsPercentage = digits * 100 / str.length();
        int specialCharsPercentage = specialChars * 100 / str.length();

        System.out.println();
        System.out.println("LowerCase Percentage = " + lowerCasePercentage + "%");
        System.out.println("UpperCase Percentage = " + upperCasePercentage + "%");
        System.out.println("Digits Percentage = " + digitsPercentage + "%");
        System.out.println("Special Chars Percentage = " + specialCharsPercentage + "%");
    }
}
