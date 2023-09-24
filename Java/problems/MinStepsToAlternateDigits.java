package Java.problems;

//https://www.geeksforgeeks.org/number-flips-make-binary-string-alternate/

public class MinStepsToAlternateDigits {
    public static void main(String[] args) {
        String s = "00100";
        System.out.println(minStepsToAlternateDigits(s));
    }

    public static int minStepsToAlternateDigits(String s){
        
        return Math.min(getFlipWithStartingCharacter(s, '0'), 
                        getFlipWithStartingCharacter(s, '1'));
    }

    public static int getFlipWithStartingCharacter(String str, char expected){
        int flipCount = 0;

        for (int i = 0; i < str.length(); i++)
            {
                if (str.charAt(i) != expected)
                        flipCount++;
                    
                expected = flip(expected);
            }

        return flipCount;
    }

     public static char flip(char ch)
    {
        return (ch == '0') ? '1' : '0';
    }
}
