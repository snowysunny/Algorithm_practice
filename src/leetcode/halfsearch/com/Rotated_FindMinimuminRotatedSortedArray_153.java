package leetcode.halfsearch.com;

/**
 * Time: 2019-06-05
 * Author: snowy
 * Leetcode 153: Find Minimum in Rotated Sorted Array
 * 发现旋转排序数组中最小的数
 * */

public class Rotated_FindMinimuminRotatedSortedArray_153 {
    public static int findMin(int[] nums) {
        if(nums == null || nums.length < 1)
            return -1;
        int left = 0, right = nums.length -1;
        while(left < right) {
            int mid = (left + right) / 2;

            if(nums[mid] < nums[right])
                right = mid;
            else
                left = mid + 1;
        }

        return nums[left];
    }

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int res = findMin(nums);
        System.out.println(res);
    }
}
