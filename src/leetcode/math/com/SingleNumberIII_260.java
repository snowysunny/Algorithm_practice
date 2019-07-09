package leetcode.math.com;

import java.util.Arrays;

/**
 * Time: 2019-06-23
 * Author: snowy
 * Leetcode 260: Single Number III
 * */

public class SingleNumberIII_260 {
    public static int[] singleNumber(int[] nums) {
        int[] res = new int[2];

        if(nums == null || nums.length < 1)
            return res;

        int bits = nums[0];
        for(int i = 1; i < nums.length; i ++)
            bits ^= nums[i];

        int index = 0;
        // 从右向左第一个不为0的位置
        for(int i = Integer.toBinaryString(bits).length() - 1; i >= 0; i --) {
            if(Integer.toBinaryString(bits).charAt(i) == '1') {
                index = Integer.toBinaryString(bits).length() - i;
                break;
            }
        }

        for(int i = 0; i < nums.length; i ++) {
            String numStr = Integer.toBinaryString(nums[i]);
            if(numStr.length() >= index && numStr.charAt(numStr.length() - index) == '1') {
                res[1] ^= nums[i];
            } else {
                res[0] ^= nums[i];
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 3, 2, 5};

        int[] res = singleNumber(nums);

        System.out.println(Arrays.toString(res));
        System.out.println(10 & -10);
    }
}
