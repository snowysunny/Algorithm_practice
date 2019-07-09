package leetcode.dynamic.com;

import java.util.Arrays;

/**
 * Time: 2019-06-06
 * Author: snowy
 * Leetcode 983: Minimum Cost For Tickets
 * 这个也是一道完全背包问题，不过这道题的不同在于背包的容量不是连续的
 * */

public class Bag_C_MinimumCostForTickets_983 {

    public static int mincostTickets(int[] days, int[] costs) {
        if(days == null || days.length < 1 || costs == null || costs.length < 1)
            return 0;

        int[] totalCosts = new int[days[days.length - 1] + 1];
        totalCosts[0] = 0;

        totalCosts[days[0]] = Math.min(Math.min(costs[0], costs[1]), costs[2]);

        // 程序中需要注意totalCosts的索引是days[i]不是i

        for(int i = 1; i < days.length; i ++) {
            if(days[i] - days[i - 1] > 1)
                Arrays.fill(totalCosts, days[i - 1] + 1, days[i], totalCosts[days[i - 1]]);
            if(days[i] >= 30) {
                totalCosts[days[i]] = Math.min(Math.min(totalCosts[days[i] - 30] + costs[2], totalCosts[days[i] - 7] + costs[1]), totalCosts[days[i] - 1] + costs[0]);
            } else if(days[i] >= 7) {
                totalCosts[days[i]] = Math.min(Math.min(costs[2], totalCosts[days[i] - 7] + costs[1]), totalCosts[days[i] - 1] + costs[0]);
            } else {
                totalCosts[days[i]] = Math.min(Math.min(costs[2], costs[1]), totalCosts[days[i] - 1] + costs[0]);
            }
        }



        return totalCosts[totalCosts.length - 1];
    }

    public static void main(String[] args) {
        int[] days = {1,2,3,4,5,6,7,8,9,10,30,31};
        int[] costs = {2, 7, 15};
        int res = mincostTickets(days, costs);
        System.out.println(res);

    }
}
