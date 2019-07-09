package leetcode.halfsearch.com;

/**
 * Time: 2019-05-03
 * Author: snowy
 * Leetcode 33: Search in Rotated Sorted Array
 * 可以画个图看看
 * */

public class Rotated__SearchinRotatedSortedArray_33 {
    public static int search(int[] nums, int target) {
        if(nums.length < 1 || nums == null)
            return -1;

        int left = 0, right = nums.length - 1;
        int mid = 0;
        while(left <= right) {
            mid = (left + right) / 2;

            if(nums[mid] == target)
                return mid;

            if(nums[mid] > nums[right]) {
                // 先考虑简单的情形，复杂的情形直接归纳一下
                if(nums[mid] > target && nums[left] <= target)
                    right = mid - 1;
                else
                    left = mid + 1;
            } else {
                // 先考虑简单的情形，复杂的情形直接归纳一下
                if(nums[mid] < target && target <= nums[right])
                    left = mid + 1;
                else
                    right = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {4, 1, 2};
        int target = 2;
        int res = search(nums, target);
        System.out.println(res);
    }

}
