package leetcode.dynamic.com;

/**
 * Time: 2019-06-24
 * Author: snowy
 * Leetcode 714: Best Time to Buy and Sell Stock with Transaction Fee
 * */

public class BestTimetoBuyandSellStockwithTransactionFee_714 {

    public static int maxProfit(int[] prices, int fee) {
        if(prices == null || prices.length < 2)
            return 0;

        int buy = prices[0], profit = 0;
        for(int i = 1; i < prices.length; i ++) {
            if(prices[i] < buy)
                buy = prices[i];
            else {
                int temp = prices[i] - buy -fee;        // 如果buy不是前一天的价格，则需要减去手续费， 如果buy是前一天卖出的价格，那么手续费就被抵消了
                if(temp > 0) {
                    profit += temp;
                    buy = prices[i] - fee;      // 更新买入价格为当前价格减去手续费
                }
            }
        }

        return profit;
    }

    public static void main(String[] args) {
        int[] prices = {1, 3, 2, 8, 4, 9};
        int fee = 2;
        int res = maxProfit(prices, fee);
        System.out.println(res);
    }
}
