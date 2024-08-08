package Java.leetcode.easy;

import java.util.stream.IntStream;

public class ScoreOfAString{
    public static void main(String[] args) {
        System.out.println(scoreOfAString2("zaz"));
    }

    public static int scoreOfAString(String s){
        int score = 0;
        for(int i = 1 ; i < s.length() ; i++){
            score += Math.abs(s.charAt(i) - s.charAt(i-1));
        }
        return score;
    }

    //USING STREAMS
    public static int scoreOfAString2(String s){
        return IntStream.range(0, s.length()-1)
                        .map(i -> Math.abs(s.charAt(i) - s.charAt(i+1)))
                        .sum();
    }
}