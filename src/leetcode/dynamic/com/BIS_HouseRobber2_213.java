package leetcode.dynamic.com;

/**
 * Time: 2019-06-13
 * Author: snowy
 * Leetcode 213: House Robber II
 * */

public class BIS_HouseRobber2_213 {
    public static int rob(int[] nums) {
        if(nums == null || nums.length < 1)
            return 0;
        if(nums.length == 1)
            return nums[0];

        if(nums.length == 2)
            return Math.max(nums[0], nums[1]);

        int res = Math.max(robHealper(nums, 0, nums.length - 1), robHealper(nums, 1, nums.length));

        return res;
    }

    public static int robHealper(int[] nums, int start, int end) {
        int[] dp = new int[end];

        dp[start] = nums[start];
        dp[start + 1] = Math.max(nums[start], nums[start + 1]);

        for(int i = start + 2; i < end; i ++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }

        return dp[end - 1];
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 2};
        int res = rob(nums);
        System.out.println(res);
    }
}
