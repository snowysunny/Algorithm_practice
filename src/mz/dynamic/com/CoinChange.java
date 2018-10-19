package mz.dynamic.com;

/**
 *  Time: 2018-10-17    Author: Snowy
 *  动态规划： 322. Coin Change 硬币找零
 *  给定一个非负整数num。对于每一个满足0 ≤ i ≤ num的数字i，计算其数字的二进制表示中1的个数，并以数组形式返回
 *  本文参考链接： https://blog.csdn.net/snowy19130140/article/details/83148828
 * */

import java.util.Arrays;

public class CoinChange {
    public int MY_coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i ++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j ++) {
                if (i < coins[j])
                    continue;
                int pre = i - coins[j];

                if (dp[pre] == -1)
                    continue;
                else
                    min = Math.min(min, dp[pre] + 1);
            }
            if (min == Integer.MAX_VALUE)
                min = -1;
            dp[i] = min;

        }
        return dp[amount];
    }


    ///////////////////////////////////////////////////////////////////////////////
    /**
     * 自顶向下的计算方法, 参考leetcode后面的解析
     * Time: O(S*n)    Space: O(S)   m is the amount, n is the size of coins
     * @param coins
     * @param amount
     * */
    public int coinChange_TopDown(int[] coins, int amount) {
        if (amount <= 0)
            return 0;

        return coinChange(coins, amount, new int[amount]);
    }

    /**
     * @param count: 用于存储小于等于amount整数由coins构成的最小个数
     * */
    public int coinChange(int[] coins, int remain, int[] count) {
        if (remain < 0)
            return -1;
        if (remain == 0)
            return 0;
        if (count[remain - 1] != 0)
            return count[remain - 1];
        int min = Integer.MAX_VALUE;
        for (int coin: coins) {
            int res = coinChange(coins, remain - coin, count);
            if (res >= 0 && res < min)
                min = res + 1;
        }
        count[remain - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return count[remain - 1];
    }

    ///////////////////////////////////////////////////////////////////////////////

    /**
     * 自底向上的计算方法, 参考leetcode后面的解析
     * Time: O(S*n)    Space: O(S)   m is the amount, n is the size of coins
     * @param coins
     * @param amount
     * */
    public int coinChange_BottomUp(int[] coins, int amount) {
        if (amount <= 0)
            return 0;
        int []dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i ++) {
            for(int coin : coins) {
                if (i - coin >= 0)
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return (dp[amount] > amount) ? -1 : dp[amount];
    }

    // 测试一下
    public static void main(String[] args) {
        CoinChange cc = new CoinChange();
        int []coins = {1, 2, 5, 3, 4};
        Arrays.sort(coins);
        System.out.println(Arrays.toString(coins));
        int amount = 11;
        int res = cc.coinChange_TopDown(coins, amount);
        System.out.println(res);
    }

}
