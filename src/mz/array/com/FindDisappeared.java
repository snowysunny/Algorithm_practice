package mz.array.com;

import java.util.ArrayList;
import java.util.List;

/**
 * Time: 2018-10-07    Author: Snowy
 * LeetCode 448:  找出数组中未出现的数字
 * */

public class FindDisappeared {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i ++) {
            nums[(nums[i] - 1) % nums.length] += nums.length;
        }
        for (int i = 0; i < nums.length; i ++)
            if (nums[i] <= nums.length)
                result.add(i + 1);
        return result;
    }

    public static void main(String [] args) {
        FindDisappeared fd = new FindDisappeared();
        int []nums = new int[]{4,3,2,7,8,2,3,1};
        List<Integer> result = fd.findDisappearedNumbers(nums);

        for (int num: result) {
            System.out.print(num + " ");
        }
        System.out.println("");
    }
}
