package leetcode.dynamic.com;

import java.util.Arrays;

/**
 * Time: 2019-06-30
 * Author: snowy
 * Leetcode 300: Longest Increasing Subsequence
 * */

public class LIS_LongestIncreasingSubsequence_300 {

    /**
     * Time: O(n^2)
     * */
    public static int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length < 1)
            return 0;

        int[] cur = new int[nums.length];
        Arrays.fill(cur, 1);

        int res = 1;

        for(int i = 1; i < nums.length; i ++) {
            for(int j = i - 1; j >= 0; j --) {
                if(nums[i] > nums[j]) {
                    cur[i] = Math.max(cur[i], cur[j] + 1);
                }
            }
            res = Math.max(res, cur[i]);
        }

        return res;
    }

    public static int longestLIS(int[] nums) {
        if(nums == null || nums.length < 1)
            return 0;

        int[] lis = new int[nums.length];  // 用來存储最大子序列的
        int maxlen = 0;
        lis[maxlen ++] = nums[0];

        for(int i = 1; i < nums.length; i ++) {
            if(nums[i] > lis[maxlen - 1])
                lis[maxlen ++] = nums[i];
            else {  // 更新当前的数在最长子序列中处于什么位置，替换掉
                int position = findInsertionPosition(lis, nums[i], maxlen);
                lis[position] = nums[i];
            }
        }

        return maxlen;
    }

    public static int findInsertionPosition(int[] lis, int target, int maxlen) {
        int left = 0, right = maxlen - 1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(lis[mid] == target)
                return mid;
            if(lis[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }

        return left;
    }

    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        int res = longestLIS(nums);
        System.out.println(res);
    }
}
