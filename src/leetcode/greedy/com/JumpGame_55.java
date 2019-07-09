package leetcode.greedy.com;

/**
 * Time: 2019-05-20
 * Author: snowy
 * Leetcode 55: Jump Game
 * */

public class JumpGame_55 {

    public static boolean canJump(int[] nums) {
        int last = 0;
        for(int i = 0; i < nums.length; i ++) {
            if(i > last)        // 超出当前的范围了
                return false;
            last = Math.max(i + nums[i], last);
            if(last >= nums.length - 1)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {0};
        boolean res = canJump(nums);
        System.out.println(res);
    }
}
