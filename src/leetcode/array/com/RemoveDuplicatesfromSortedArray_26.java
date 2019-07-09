package leetcode.array.com;

/**
 * Time: 2019-05-02
 * Author: snowy
 * Leetcode 26: Remove Duplicates from Sorted Array
 * */

public class RemoveDuplicatesfromSortedArray_26 {

    public static int removeDuplicates(int[] nums) {
        if(nums.length < 1 || nums == null)
            return 0;

        // 记录不同数的个数
        int count = nums.length;

        for(int i = 1, j = 1; i < nums.length; i ++) {
            if(nums[i] == nums[i - 1])
                count --;
            else {
                nums[j] = nums[i];
                j ++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int res = removeDuplicates(nums);
        System.out.println(res);
    }
}
