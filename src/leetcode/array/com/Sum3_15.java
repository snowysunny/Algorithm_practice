package leetcode.array.com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Time: 2019-04-26
 * Author: snowy
 * leetcode 15:  3Sum
 * */


public class Sum3_15 {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length < 3 || nums == null)
            return res;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i ++) {
            if(i > 0 && nums[i] == nums[i - 1])         // 避免重复
                continue;
            int left = i + 1, right = nums.length - 1;
            while(left < right) {
                if(nums[i] + nums[left] + nums[right] < 0) {
                    left ++;
                } else if(nums[i] + nums[left] + nums[right] > 0) {
                    right --;
                } else {
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[left]);
                    temp.add(nums[right]);
                    res.add(temp);
                    left ++;
                    right --;
                    while(left < right && nums[left] == nums[left - 1])         // 重复过滤
                        left ++;
                    while(right > left && nums[right] == nums[right + 1])
                        right --;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        Arrays.sort(nums);

        System.out.println(Arrays.toString(nums));
        List<List<Integer>> res = threeSum(nums);
        for(List<Integer> ans : res)
            System.out.println(ans);
    }
}
