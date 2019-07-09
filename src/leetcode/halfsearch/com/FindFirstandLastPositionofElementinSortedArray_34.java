package leetcode.halfsearch.com;

import java.util.Arrays;

/**
 * Time: 2019-05-04
 * Author: snowy
 * Leetcode 34: Find First and Last Position of Element in Sorted Array
 * */

public class FindFirstandLastPositionofElementinSortedArray_34 {

    public static int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        if(nums.length < 1 || nums == null)
            return res;

        int left = 0, right = nums.length - 1;

        while(left <= right) {
            int mid = (left + right) / 2;
            if(nums[mid] == target) {
                int start = mid, end = mid;
                while(start >= left) {      // 找开始位置
                    if(nums[start] == target) {
                        res[0] = start;
                        start --;
                    } else {
                        break;
                    }
                }
                while(end <= right) {       // 找结束位置
                    if(nums[end] == target) {
                        res[1] = end;
                        end ++;
                    } else {
                        break;
                    }
                }
                return res;
            } else if(nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int[] res = searchRange(nums, 6);
        System.out.println(Arrays.toString(res));
    }
}
