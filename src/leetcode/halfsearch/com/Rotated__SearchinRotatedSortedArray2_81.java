package leetcode.halfsearch.com;

/**
 * Time: 2019-05-23
 * Author: snowy
 * Leetcode 81: Search in Rotated Sorted Array II
 * */

public class Rotated__SearchinRotatedSortedArray2_81 {
    public static boolean search(int[] nums, int target) {
        if(nums == null || nums.length < 1)
            return false;

        int left = 0, right = nums.length - 1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(nums[mid] == target)
                return true;
            if(nums[mid] > nums[right]) {       // 中点在左半边
                if(target >= nums[left] && target < nums[mid]) {        // 先考虑简单的情况，一边是单调的
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if(nums[mid] < nums[right]){ // 中点在右半边
                if(target > nums[mid] && target <= nums[right]) {       // 先考虑简单的情况，一边是单调的
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                right --;
            }

        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = {2,5,6,0,0,1,2};
        int target = 6;
        boolean res = search(nums, target);
        System.out.println(res);
    }
}
