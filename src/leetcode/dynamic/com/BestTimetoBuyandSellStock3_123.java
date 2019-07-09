package leetcode.dynamic.com;

/**
 * Time: 2019-05-06
 * Author: snowy
 * Leetcode 123: Best Time to Buy and Sell Stock III
 * */

public class BestTimetoBuyandSellStock3_123 {
    /**
     * the max profit is (4 - 1) + (3 - 0), which is also equal to 4 - (1 - (3 - 0))
     * '0' is the min of cost1, (3 - 0) is the profit1, (1 - (3 - 0)) is the cost2, and 4 - (1 - (3 - 0)) is the profit2
     * this also works for the increasing sequence, say, 1,2,3,4, the max profit is 4 - (4 - (4 - 1))
     * in order to get the max profit eventually, profit1 must be as relatively most as possible to produce a small cost2, and therefore cost2 can be as less as possible to give us the final max profit2. So now we understand why and where we need to take min or max of all cost and profit variables.....
     * */
    public static int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2)
            return 0;

        // 两次买入的价格价格
        int buy1 = Integer.MAX_VALUE, buy2 = Integer.MAX_VALUE;
        // 第一次的利润
        int profit1 = 0;
        // 两次的总利润
        int profit2 = 0;

        for(int price : prices) {
            buy1 = Math.min(buy1, price);                   // 买入的价格尽量的小
            profit1 = Math.max(profit1, price - buy1);      // 第一次获利尽可能大
            buy2 = Math.min(buy2, price - profit1);         // 第二次买股票花的钱可以看做是原本的钱减去第一次卖出股票后获得的利润
            profit2 = Math.max(profit2, price - buy2);
        }

        return profit2;
    }

    public static void main(String[] args) {
        int[] prices = {3,3,5,0,0,3,1,4};
        int res = maxProfit(prices);
        System.out.println(res);
    }
}
