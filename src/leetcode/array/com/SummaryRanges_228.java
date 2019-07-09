package leetcode.array.com;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges_228 {

    public static List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if(nums == null || nums.length < 1)
            return res;

        int left = 0, right = 0;
        String temp = null;
        for(int i = 1; i < nums.length; i ++){
            if(nums[right] + 1 == nums[i]) {
                right = i;
            }
            else {
                if(left == right) {
                    temp = String.valueOf(nums[left]);
                    res.add(temp);
                } else {
                    temp = nums[left] + "->" + nums[right];
                    res.add(temp);
                }
                left = right = i;
            }
        }

        if(left == right) {
            temp = String.valueOf(nums[left]);
            res.add(temp);
        } else {
            temp = nums[left] + "->" + nums[right];
            res.add(temp);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {0,2,3,4,6,8,9};
        List<String> res = summaryRanges(nums);
        System.out.println(res);
    }
}
