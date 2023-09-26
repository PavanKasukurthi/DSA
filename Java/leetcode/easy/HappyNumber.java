package Java.leetcode.easy;

//GOOGLE QUESTION
public class HappyNumber {
    public static void main(String[] args) {
        System.out.println(isHappy(18));

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

    //LINKEDLIST APPROACH
    public static boolean isHappy(int n){

        int slow = n;
        int fast = n;

        findSquare(n);

        do{
            slow = findSquare(slow);
            fast = findSquare((findSquare(fast)));
        }
        while(fast != slow);

        if(slow == 1){
            return true;
        }

        return false;
    }

    private static int findSquare(int number){
        int ans = 0;
        while(number > 0){
            int rem = number % 10;
            ans += rem * rem;
            number = number / 10;
        }
        return ans;
    }
}
