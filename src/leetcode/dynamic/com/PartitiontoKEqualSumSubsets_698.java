package leetcode.dynamic.com;

import java.util.ArrayList;
import java.util.List;

/**
 * Time: 2019-06-29
 * Author: snowy
 * Leetcode 698: Partition to K Equal Sum Subsets
 * 这道题虽然放在了动态规划里面，但是这道题其实在解法上使用的完全是dfs的思想， 当然放在动规里面也是为了和416题放在一起
 * */

public class PartitiontoKEqualSumSubsets_698 {

    public static boolean canPartitionKSubsets(int[] nums, int k) {
        if(nums == null || nums.length < 1)
            return false;

        int sum = 0;
        for(int i = 0; i < nums.length; i ++)
            sum += nums[i];

        if(sum % k != 0 || sum < k)     // 进行基本的判断
            return false;

        boolean[] visited = new boolean[nums.length];       // 存储是否已经访问过

        List<List<Integer>> res = new ArrayList<>();

        return PartitionCore(nums, visited, 0, k, 0,sum / k);
    }

    /**
     * @param nums: 原数组
     * @param visited: 记录已经被访问过的
     * @param start
     * @param k:
     * @param target: 目标数量
     * */
    public static boolean PartitionCore(int[] nums, boolean[] visited, int start, int k, int cur_sum, int target) {
        if(k == 1)
            return true;

        if(cur_sum == target)
            return PartitionCore(nums, visited, 0, k - 1, 0, target);

        for(int i = start; i < nums.length; i ++) {
            if(!visited[i]) {

                if(cur_sum + nums[i] > target)
                    continue;

                visited[i] = true;
                if(PartitionCore(nums, visited, i + 1, k, cur_sum + nums[i], target))
                    return true;
                visited[i] = false;
            }
        }

        return false;
    }


    public static void main(String[] args) {
        int[] nums = {4,3,2,3,5,2,1};
        int k = 5;
        boolean res = canPartitionKSubsets(nums, k);
        System.out.println(res);
    }
}
