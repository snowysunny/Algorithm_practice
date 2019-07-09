package leetcode.dynamic.com;

/**
 * Time: 2019-06-06
 * Author: snowy
 * Leetcode 416: Partition Equal Subset Sum
 * 这道题是0-1背包问题的一种，好像在面试的时候常常会见到，因此这道题需要多看几次，经常复习
 * */


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1. 这道题的解法可以使用深度优先搜索的方式，转化成一个数组中的元素之和
 * 2. 使用动态规划的思想实现,使用01背包的方法实现
 * */

public class PartitionEqualSubsetSum_416 {

    // 深度优先搜索的解法会超时
    public static boolean canPartition_dfs(int[] nums) {
        if(nums == null || nums.length < 2)
            return false;

        int sum = 0;
        for(int num : nums)
            sum += num;
        if(sum % 2 != 0)
            return false;
        Arrays.sort(nums);
        List<List<Integer>> res= new ArrayList<>();

        canPartition_dfsCore(nums, 0, sum/2, res, new ArrayList<>());


        return res.size() > 0 ? true : false;
    }

    public static void canPartition_dfsCore(int[] nums, int start, int sum, List<List<Integer>> res, List<Integer> path) {
        if(sum <= 0) {
            if(sum == 0)
                res.add(new ArrayList<>(path));
            return;
        }

        for(int i = start; i < nums.length; i ++) {
            path.add(nums[i]);
            canPartition_dfsCore(nums, i + 1, sum - nums[i], res, path);
            path.remove(path.size() - 1);
        }
    }


    // 动态规划的解法  但是这道题很奇怪，就是需要从后向前遍历，不然会时间超时，这不合理
    public static boolean canPartition_dg(int[] nums) {
        if(nums == null || nums.length < 2)
            return false;

        int sum = 0;
        for(int num : nums)
            sum += num;
        if(sum % 2 != 0)
            return false;

//        return isSum(nums, sum/2, 0);
        return isSum(nums, sum/2, nums.length - 1);
    }

    public static boolean isSum(int[] nums, int sum, int start) {
        if(sum == 0)
            return true;

//        for(int i = start; i < nums.length; i ++) {
        for(int i = start; i >= 0; i --) {
            if(sum < nums[i])
                break;
            if(isSum(nums, sum - nums[i], i - 1))
                return true;
        }

        return false;
    }

    // 0-1背包的解法
    public static boolean canPartition_dp(int[] nums) {
        if(nums == null || nums.length < 2)
            return false;

        int sum = 0;
        for(int num : nums)
            sum += num;
        if(sum % 2 != 0)
            return false;

        boolean[] dp = new boolean[sum / 2 + 1];
        dp[0] = true;

        for(int num : nums) {
            for(int j = sum / 2; j >= num; j --) {
                dp[j] = dp[j] || dp[j - num];
            }
            System.out.println(Arrays.toString(dp));
        }
        return dp[sum / 2];
    }

    public static void main(String[] args){
        int[] nums = {1, 5, 11, 5};
        boolean res = canPartition_dp(nums);
        System.out.println(res);
    }
}
