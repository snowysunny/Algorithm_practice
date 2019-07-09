package leetcode.halfsearch.com;

/**
 * Time: 2019-06-07
 * Author: snowy
 * Leetcode 162: Find Peak Element
 * */

public class FindPeakElement_162 {

    public static int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;

        while(left < right) {
            int mid = (left + right) / 2;

            if(nums[mid] < nums[mid + 1])
                left = mid + 1;
            else
                right = mid;
        }

        return left;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,1,3,5,6,4};
        int res = findPeakElement(nums);
        System.out.println(res);

    }
}
