package leetcode.dynamic.com;

import java.util.HashMap;
import java.util.Map;

/**
 * Time: 2019-07-02
 * Author: snowy
 * Leetcode 523: Continuous Subarray Sum
 * */

public class ContinuousSubarraySum_523 {

    // Time: O(n^2)
    public static boolean checkSubarraySum_loop(int[] nums, int k) {
        if(nums == null || nums.length < 2)
            return false;
        for(int i = 0; i < nums.length - 1; i ++){
            if(nums[i] == 0 && nums[i + 1] == 0)
                return true;
        }

        if( k == 0)
            return false;

        int sum = 0;
        for(int i = 0; i < nums.length; i ++) {
            sum = nums[i];
            for(int j = i + 1; j < nums.length; j ++) {
                sum += nums[j];
                if(sum % k == 0)
                    return true;
            }
        }

        return false;
    }

    public static boolean checkSubarraySum(int[] nums, int k) {
        if(nums == null || nums.length < 2)
            return false;
        for(int i = 0; i < nums.length - 1; i ++){
            if(nums[i] == 0 && nums[i + 1] == 0)
                return true;
        }
        if( k == 0)
            return false;

        Map<Integer, Integer> map = new HashMap<>();        // 第一个元素存储余数， 第二个位置存储余数产生的位置
        int sum = 0;

        for(int i = 0; i < nums.length; i ++) {
            sum += nums[i];
            int mod = sum % k;
            if(map.containsKey(mod)) {
                int index = map.get(mod);
                if(i - index > 1)
                    return true;
            } else {
                map.put(mod, i);
            }
        }

        return false;
    }



    public static void main(String[] args) {
        int[] nums = {1, 1};
        int k = -1;
        boolean res = checkSubarraySum(nums, k);
        System.out.println(res);
    }
}
