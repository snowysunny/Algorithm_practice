package leetcode.dynamic.com;

import java.util.Arrays;

/**
 * Time： 2019-06-05
 * Author: snwoy
 * Leetcode 322: knapsack
 * 典型的完全背包问题——硬币找零问题
 * */

public class Bag_C_CoinChange_322 {
    public static int coinChange(int[] coins, int amount) {
        if(coins == null || coins.length < 1)
            return -1;

        int[] count = new int[amount + 1];
        Arrays.fill(count, amount + 1);
        count[0] = 0;

        for(int i = 1; i <= amount; i ++) {
            for(int coin : coins) {
                if(i >= coin) {
                    count[i] = Math.min(count[i], count[i - coin] + 1);
                }
            }
            System.out.println(Arrays.toString(count));
        }

        return count[amount] > amount ? -1 : count[amount];
    }


    // 完全背包的解法
    public static int coinChange_2(int[] coins, int amount) {
        if(coins == null || coins.length < 1)
            return -1;

        int[] count = new int[amount + 1];
        Arrays.fill(count, amount + 1);
        count[0] = 0;

        for(int coin : coins){
            for(int  i = coin; i <= amount; i ++)               // 这个地方注意啦，和0-1背包不同的地方就在这儿
                count[i] = Math.min(count[i - coin] + 1, count[i]);
        }
        return count[amount] > amount ? -1 : count[amount];
    }

    // 0-1背包问题
    public static int coinChange_3(int[] coins, int amount) {
        if(coins == null || coins.length < 1)
            return -1;

        int[] count = new int[amount + 1];
        Arrays.fill(count, amount + 1);
        count[0] = 0;

        for(int coin:coins) {
            for(int i = amount; i >= coin; i --)                // 这个地方注意啦，和完全背包不同的地方就在这儿
                count[i] = Math.min(count[i], count[i - coin] + 1);
            System.out.println(Arrays.toString(count));
        }

        return count[amount];
    }

    public static void main(String[] args) {
        int[] coins = {1, 1, 4, 5, 5, 4, 4, 4};
        int amount = 12;
        int res = coinChange_3(coins, amount);
        System.out.println(res);
    }
}
