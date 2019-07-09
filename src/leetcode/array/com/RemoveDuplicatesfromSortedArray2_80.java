package leetcode.array.com;

import java.util.Arrays;

/**
 * Time: 2019-05-22
 * Author: snowy
 * Leetcode 80: Remove Duplicates from Sorted Array II
 * */

public class RemoveDuplicatesfromSortedArray2_80 {
//    知识点：输入数组是以“引用”方式传递的即部队是残做任何拷贝，这意味着在函数里修改输入数组对于调用者是可见的
    public static int removeDuplicates(int [] nums) {
        if(nums == null || nums.length < 1)
            return 0;

        int count = 0, cur = 1;         // count用于记录当前需要的偏移，也就是需要移除数的个数， cur记录的是当前数重复的个数
        for(int i = 1; i < nums.length; i ++) {
            if(nums[i] == nums[i - 1])
                cur ++;
            else {
                if(cur > 2)
                    count += cur - 2;
                cur = 1;
            }

            nums[i - count] = nums[i];
        }
        // System.out.println(Arrays.toString(nums));

        if (cur > 2)         // 最后一个数重复多次
            count += cur - 2;

        return nums.length - count;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int res = removeDuplicates(nums);
        System.out.println(Arrays.toString(nums));
        System.out.println(res);
    }
}
