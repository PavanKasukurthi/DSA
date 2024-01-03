package Java.leetcode.medium;

public class NumberOfLaserBeamsInABank {
    public int numberOfBeams(String[] bank) {
        int prev = 0, ans = 0;

        for(String s : bank){

            int count = 0;
            while(s.length() > 0){
                if(s.charAt(s.length() - 1) == '1') count++;
                s = s.substring(0, s.length());
            }

            if(count > 0){
                ans += prev * count;
                prev = count;
            }
        }

        return ans;
    }
}
