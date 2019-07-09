package leetcode.halfsearch.com;

/**
 * Time: 2019-05-12
 * Author: snowy
 * Leetcode 35： Search Insert Position
 * */

public class SearchInsertPosition {
    public static int searchInsert(int[] nums, int target) {
        if(nums.length < 1 || nums == null)
            return 0;

        int left = 0, right = nums.length - 1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(nums[mid] == target)
                return mid;

            if(nums[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return left;
    }

    public static void main(String[] args) {
        int nums[] = {1,3,5,6};
        int target = 0;
        int res = searchInsert(nums, target);
        System.out.println(res);
    }
}
