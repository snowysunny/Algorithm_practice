package leetcode.dynamic.com;

/**
 * Time: 2019-06-28
 * Author: snowy
 * Leetcode 376: Wiggle Subsequence
 * */

public class WiggleSubsequence_376 {

    public static int wiggleMaxLength(int[] nums){
        if(nums == null || nums.length < 1)
            return 0;

        if(nums.length == 1)
            return 1;

        int flag = 1;    // +
        int res = 1;
        int i = 1;
        for (; i < nums.length; i ++) {  // 首先需要知道最开始的不相等的两位的大小
            if(nums[i] == nums[i - 1])
                continue;

            if(nums[i] > nums[i - 1])
                flag = 1;
            else
                flag = -1;
            res ++;
            break;
        }
        i ++;

        for(; i < nums.length; i ++) {      // 局部单调增的话就取最大的那个作为结束点， 局部单调减则取最小的那个作为结束点, 出现摆动则计数并且变换符号
            if(flag == 1) {
                if(nums[i] >= nums[i - 1])
                    continue;
                else {
                    res ++;
                    flag = -1;
                }
            } else {
                if(nums[i] <= nums[i - 1])
                    continue;
                else{
                    res ++;
                    flag = 1;
                }
            }
        }


        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8,9};
        int res = wiggleMaxLength(nums);
        System.out.println(res);
    }
}
