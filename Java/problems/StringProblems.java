package Java.problems;

public class StringProblems {
    public static void main(String[] args) {
        // System.out.println(reverseString2("ReverseThisString"));
        // System.out.println(reverseWordsInAString("Reverse this string"));
        // System.out.println(checkRotation("aab", "aba"));
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

}
