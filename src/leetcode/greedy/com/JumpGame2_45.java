package leetcode.greedy.com;

/**
 * Time: 2019-05-20
 * Author: snowy
 * Leetcode 45: Jump Game II
 * */

public class JumpGame2_45 {
    public static int jump(int[] nums) {
        if(nums.length <= 1)
            return 0;

        int last = 0, curlast = 0;
        int step = 0;

        for(int i = 0; i < nums.length; i ++) {
            last = Math.max(last, i + nums[i]);

            if(i == curlast) {
                step ++;
                curlast = last;     // 当前范围向后移动
                if(curlast >= nums.length - 1) {
                    return step;
                }
            }

        }
        return step;
    }

    public static void main(String[] args) {
        int[] nums = {2, 1};
        int res = jump(nums);
        System.out.println(res);
    }
}
