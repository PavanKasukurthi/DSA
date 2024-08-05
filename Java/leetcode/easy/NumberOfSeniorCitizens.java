package Java.leetcode.easy;

import java.util.Arrays;

public class NumberOfSeniorCitizens {
    public static void main(String[] args) {
        String[] details = {"7868190130M7522","5303914400F9211","9273338290F4010"};
        System.out.println(countSeniors2(details));
    }

    public static int countSeniors(String[] details) {
        int count = 0;

        for(String s : details){
            if(Integer.parseInt(s.substring(11, 13)) > 60) count++;
        }

        return count;
    }

    //USING STREAMS
    public static int countSeniors2(String[] details){
        return (int)Arrays.stream(details)
                .map(detail -> detail.substring(11, 13))
                .mapToInt(Integer::parseInt)
                .filter(age -> age > 60)
                .count();
    }
}
