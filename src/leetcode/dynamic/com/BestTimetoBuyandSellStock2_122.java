package leetcode.dynamic.com;

/**
 * Time: 2019-05-06
 * Author: snowy
 * Leetcode 122: Best Time to Buy and Sell Stock II
 * */

public class BestTimetoBuyandSellStock2_122 {

    public static int maxProfit(int[] prices){
        if(prices == null || prices.length < 1)
            return 0;

        int sum = 0;
        for(int i = 1; i < prices.length; i ++) {
            sum = Math.max(sum, sum + prices[i] - prices[i - 1]);
        }

        return sum;
    }

    public static void main(String[] args){
        int[] prices = {1,2,3,4,5};
        int res = maxProfit(prices);
        System.out.println(res);
    }

}
