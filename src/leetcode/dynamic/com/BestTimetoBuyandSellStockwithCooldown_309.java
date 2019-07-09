package leetcode.dynamic.com;

/**
 * Time: 2019-06-24
 * Author: snowy
 * Leetcode 309: Best Time to Buy and Sell Stock with Cooldown
 * */

public class BestTimetoBuyandSellStockwithCooldown_309 {

    /**
     * Define:
     *          profit1[i] = max profit on day i if I sell
     *          profit2[i] = max profit on day i if I do nothing
     *
     *How will those profits on day i+1 relate to profits on day i ?\
     *          1. profit1[i+1] means I must sell on day i+1, and there are 2 cases:
     *          a. If I just sold on day i, then I have to buy again on day i and sell on day i+1
     *          ******************   b. If I did nothing on day i, then I have to buy today and sell today   ***********************
     *          Taking both cases into account, profit1[i+1] = max(profit1[i]+prices[i+1]-prices[i], profit2[i])
     *
     *          2. profit2[i+1] means I do nothing on day i+1, so it will be max(profit1[i], profit2[i])
     *
     * */


    public static int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2)
            return 0;

        int profit1 = 0, profit2 = 0;
        for(int i = 1; i < prices.length; i ++) {
            int profit = profit1;
            profit1 = Math.max(profit2, profit1 + prices[i] - prices[i - 1]);
            profit2 = Math.max(profit, profit2);

            System.out.println(profit1 + ", " + profit2);
        }

        return Math.max(profit1, profit2);
    }

    public static void main(String[] args) {
        int[] prices = {1,2,3,0,2};
        int res = maxProfit(prices);
        System.out.println(res);
    }
}
