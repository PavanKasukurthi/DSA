package Java.leetcode.easy;

import java.util.Stack;

public class ValidParantheses {

    // WITHOUT USING STACK
    public static boolean isValid(String s) {
        int lengthBefore = -1;

        while (lengthBefore != s.length()) {
            lengthBefore = s.length();
            s = s.replace("()", "")
                    .replace("[]", "")
                    .replace("{}", "");
        }

        return s.isEmpty();
    }

    // USING STACK
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
