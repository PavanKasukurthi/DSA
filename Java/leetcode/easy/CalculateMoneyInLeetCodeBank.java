package Java.leetcode.easy;

public class CalculateMoneyInLeetCodeBank {
    public static void main(String[] args) {
        System.out.println(totalMoney(4));
    }

     public static int totalMoney(int n) {
        int week = n / 7;
        int days = n % 7;
        int ans = solve(week);

        if(days > 0){
            int monday = week + 1;
            while(days != 0){
                ans += monday;
                monday++;
                days--;
            }
        }

        return ans;
    }

    public static int solve(int week){
        int ans = 0;

        for(int i = 0 ; i < week ; i++){
            ans += 28 + (i*7);
        }

        return ans;
    }
}
