package leetcode.array.com;

/**
 * Time: 2019-06-28
 * Author: snowy
 * Leetcode 287: Find the Duplicate Number
 * */

public class FindtheDuplicateNumber_287 {


    /**
     * 使用快慢指针的解法，题目中有限制，原数组设为只读
     * */
    public static int findDuplicate(int[] nums) {
        int slow = nums[0], fast = nums[nums[0]];
        while(slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        int finder = 0;
        while (slow != finder) {
            slow = nums[slow];
            finder = nums[finder];
        }

        return finder;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,4,0,2};
        int res = findDuplicate(nums);
        System.out.println(res);
    }
}
