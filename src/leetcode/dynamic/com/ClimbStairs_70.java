package leetcode.dynamic.com;

/**
 * Time: 2019-05-30
 * Author: snowy
 * Leetcode 70: climbStairs
 * */

public class ClimbStairs_70 {
    public static int climbStairs(int n) {
        if(n <= 1)
            return 1;

        int left = 1, right = 1, res = 1;

        for(int i = 2; i <= n; i ++) {
            res = left + right;
            left = right;
            right = res;
        }

        return res;
    }

    public static void main(String[] args) {
        int n = 5;
        int res = climbStairs(n);
        System.out.println(res);
    }
}
