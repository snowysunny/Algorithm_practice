package leetcode.sort.com;

import java.util.Arrays;

/**
 * Time: 2019-07-06
 * Author: snowy
 * Leetcode 324: Wiggle Sort II
 * */

public class WiggleSortII_324 {

    public static void wiggleSort(int[] nums) {
        if(nums == null || nums.length < 2)
            return;

        Arrays.sort(nums);

        int[] copy = Arrays.copyOf(nums, nums.length);
        int mid = nums.length / 2;

        if(( nums.length&1) == 0 )
            mid--;

        for(int i = mid; i >= 0; i --) {
            nums[2 * (mid - i)] = copy[i];
        }

        for(int i = nums.length - 1; i > mid; i --) {
            nums[2 * (nums.length - 1 - i) + 1] = copy[i];
        }

    }


    public static void main(String[] args) {
        int[] nums = {1,1,2,1,2,2,1};
        wiggleSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
