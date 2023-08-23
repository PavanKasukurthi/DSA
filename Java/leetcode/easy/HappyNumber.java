package Java.leetcode.easy;

public class HappyNumber {
    public static void main(String[] args) {
        System.out.println(happyNumber(4));

    }

    public static boolean happyNumber(int n){
        if(n == 1 || n == 7) return true;
        if(n % 10 == n) return false;

        int sum = 0;
        int temp = n;

        while(temp != 0){
            sum += (temp%10)*(temp%10);
            temp = temp/10;
        }

        if(sum == 1){
            return true;
        }
        else if (sum == 0){
            return false;
        }

        System.out.println(sum);
        return happyNumber(sum);
    }
}
