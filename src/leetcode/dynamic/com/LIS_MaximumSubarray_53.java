package leetcode.dynamic.com;

/**
 * Time: 2019-05-18
 * Author: snowy
 * Leetcode 53: Maximum Subarray
 * */

public class LIS_MaximumSubarray_53 {

    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length < 1)
            return 0;

        int max = nums[0], sum = 0;
        for(int i = 0; i < nums.length; i ++) {
            sum += nums[i];
            max = Math.max(sum, max);
            if (sum < 0)
                sum = 0;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int res = maxSubArray(nums);
        System.out.println(res);
    }
}
