package leetcode.array.com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sum4_18 {
    public static  ArrayList<ArrayList<Integer>> fourSum(int[] nums, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for(int i = 0; i < nums.length - 3; i ++) {
            if(i > 0 && nums[i] == nums[i - 1])
                continue;
            int new_target = target - nums[i];

            // 下面就是一个3Sum的程序
            for(int j = i + 1; j < nums.length - 2; j ++) {
                if(j > i + 1 && nums[j] == nums[j - 1])
                    continue;
                int left = j + 1, right = nums.length - 1;
                while(left < right) {
                    if(nums[j] + nums[left] + nums[right] < new_target)
                        left ++;
                    else if(nums[j] + nums[left] + nums[right] > new_target)
                        right --;
                    else {
                        ArrayList<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[left]);
                        temp.add(nums[right]);
                        res.add(temp);
                        left ++;
                        right --;
                        while(left < right && nums[left] == nums[left - 1])
                            left ++;
                        while(left < right && nums[right] == nums[right + 1])
                            right --;
                    }
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {5,5,3,5,1,-5,1,-2};
        ArrayList<ArrayList<Integer>> res = fourSum(nums, 0);
        for(ArrayList<Integer> list:res)
            System.out.println(list);
    }

}
