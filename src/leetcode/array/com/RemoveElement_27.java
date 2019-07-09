package leetcode.array.com;

import java.util.Arrays;

/**
 * Time: 2019-05-05
 * Author: snowy
 * Leetcode 27:Remove Element
 * */

public class RemoveElement_27 {
    public static int removeElement(int[] nums, int val) {
        int count = nums.length;

        for(int i = nums.length - 1; i >= 0; i --) {
            if(nums[i] == val) {
                count --;
                nums[i] = nums[count];
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[] nums = {0,1,2,2,3,0,4,2};
        int val = 3;
        int res = removeElement(nums, val);
        System.out.println(res);
    }
}
