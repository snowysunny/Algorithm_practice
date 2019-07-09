package leetcode.bits.com;

import java.util.Arrays;

/**
 * Time: 2019-07-09
 * Author: snowy
 * Leetcode 338: Counting Bits
 * */

public class CountingBits_338 {
    public static int[] countBits(int num) {
        int[] nums = new int[num + 1];
        // 特殊情况先考虑
        if(num == 0)
            return nums;

        nums[1] = 1;
        if(num == 1) {
            return nums;
        }

        int cur = 1;        //

        for(int i = 2; i <= num; i ++) {
            if(i == 2 * cur) {
                nums[i] = 1;
                cur = 2 * cur;
            } else {
                nums[i] = nums[cur] + nums[i - cur];
            }
        }

        return nums;
    }

    public static void main(String[] args) {
        int num = 20;
        int[] res = countBits(num);
        System.out.println(Arrays.toString(res));
    }
}
