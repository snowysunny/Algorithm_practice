package leetcode.math.com;

import java.util.Arrays;

/**
 * Time: 2019-06-24
 * Author: snowy
 * Leetcode 264: Ugly Number II
 * */

public class UglyNumberII_264 {

    public static int nthUglyNumber(int n) {
        if(n < 1)
            return 0;

        int i2 = 0, i3 = 0, i5 = 0;
        int[] nums = new int[n];
        nums[0] = 1;
        for(int i = 1; i < n; i ++) {
            nums[i] = Math.min(nums[i2] * 2, Math.min(nums[i3] * 3, nums[i5] * 5));
            if(nums[i] == nums[i2] * 2)  i2 ++;
            if(nums[i] == nums[i3] * 3)  i3 ++;
            if(nums[i] == nums[i5] * 5)  i5 ++;
        }

        return nums[n - 1];
    }

    public static void main(String[] args) {
        int n = 10;
        int res = nthUglyNumber(n);
        System.out.println(res);
    }
}
