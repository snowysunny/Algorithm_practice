package leetcode.dynamic.com;

/**
 * Time: 2019-06-13
 * Author: snowy
 * Leetcode 198: House Robber
 * */

public class LIS_HouseRobber_198 {
    public static int rob(int[] nums) {
        if(nums == null || nums.length < 1)
            return 0;
        if(nums.length == 1)
            return nums[0];

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i < nums.length; i ++) {
            dp[i] = dp[i - 2] + nums[i] > dp[i - 1] ? dp[i - 2] + nums[i] : dp[i - 1];
        }

        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        int[] nums = {2, 1, 1, 2};
        int res = rob(nums);
        System.out.println(res);
    }
}
