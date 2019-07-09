package leetcode.hash.com;

import java.util.HashMap;

/**
 * Time: 2019-06-19
 * Author: snowy
 * Leetcode 128: Longest Consecutive Sequence
 * */

public class LongestConsecutiveSequence_128 {
    public static int longestConsecutive(int[] nums) {
        if(nums == null || nums.length < 1)
            return 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums)
            map.put(num, 0);
        int res = 0;
        for(int num : nums) {
            if(map.get(num) == 1)
                continue;
            else {
                int left = 1, right = 1, count = 1;
                while(map.containsKey(num - left)) {
                    map.put(num - left, 1);
                    left ++;
                    count ++;
                }

                while(map.containsKey(num + right)) {
                    map.put(num + right, 1);
                    right ++;
                    count ++;
                }
                res = Math.max(res, count);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        int res = longestConsecutive(nums);
        System.out.println(res);
    }
}
