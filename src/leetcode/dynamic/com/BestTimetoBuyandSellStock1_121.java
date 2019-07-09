package leetcode.dynamic.com;

/**
 * Time: 2019-05-06
 * Author: snowy
 * Leetcode 121: Best Time to Buy and Sell Stock  （常考题）
 * */

public class BestTimetoBuyandSellStock1_121 {
    public static  int maxProfit(int[] prices){
        if(prices.length < 1 || prices == null)
            return 0;
        int max = 0, min = prices[0];
        for(int i = 0; i < prices.length; i ++) {
            min = Math.min(prices[i], min);         // 寻找最小点
            max = Math.max(max, prices[i] - min);   // 寻找最大结果
        }
        return max;
    }


    public static int maxProfit_2(int[] prices) {
        if(prices == null || prices.length < 2)
            return 0;

        int buy = Integer.MAX_VALUE, profit = 0;
        for(int i = 0; i < prices.length; i ++) {
            buy = Math.min(buy, prices[i]);
            profit = Math.max(profit, prices[i] - buy);
        }

        return profit;
    }

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        int res = maxProfit_2(prices);
        System.out.println(res);
    }
}
