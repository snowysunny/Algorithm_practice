package leetcode.array.com;

import java.util.Arrays;

/**
 * Time:2019-05-03
 * Author: snowy
 * Leetcode 31: Next Permutation
 * 使用例子进行找规律： https://leetcode.com/media/original_images/31_Next_Permutation.gif
 * */

public class NextPermutation_31 {

    public static void nextPermutation(int[] nums) {
        if(nums.length <= 1 || nums == null)
            return;

        int i = nums.length - 2;
        for(; i >= 0; i --) {
            if(nums[i] < nums[i + 1]) {
                // 找到后面第一个比自己大的数
                int j = i + 1;
                while(j < nums.length && nums[j] > nums[i]) {
                    j ++;
                }

                // 交换位置
                swap(nums, i, j - 1);
                // 将后面的数进行反转
                reverse(nums, i + 1, nums.length - 1);
                break;
            }
        }
        if(i < 0)
            reverse(nums, 0, nums.length - 1);
    }

    /**
     * @param nums: 待操作数组
     * @param start： 数组反转开始的位置
     * @param end： 数组反转结束的位置
     * */
    public static void reverse(int[] nums, int start, int end) {
        if(start >= end)
            return;

        while(start < end) {
            swap(nums, start++, end--);
        }
    }

    public static void swap(int[] nums, int origin, int target){
        int temp = nums[origin];
        nums[origin] = nums[target];
        nums[target] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 1};
        System.out.println(Arrays.toString(nums));
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
