package Java.leetcode.medium;

import java.util.Arrays;

public class BuyTwoChocolates {

    public static void main(String[] args) {
       int[] prices = {1,2,2};
       int money = 3;

       System.out.println(buyChoco2(prices, money));
    }

    //USING SORTING
     public int buyChoco(int[] prices, int money) {
        Arrays.sort(prices);

        if(money - prices[0] - prices[1] < 0) return money;
        else return money - prices[0] - prices[1];
    }

    //O(n)
    public static int buyChoco2(int[] prices, int money){
        int min1 = Math.min(prices[0], prices[1]);
        int min2 = Math.max(prices[0],prices[1]);

        for(int i = 2 ; i < prices.length ; i++){
            if(prices[i] < min1){
                min1 = prices[i];
                min2 = min1;
            }
            else if(prices[i] < min2){
                min2 = prices[i];
            }
        }

        if(money -  min1 - min2 < 0) return money;
        else return money - min1 - min2;
    }
}
