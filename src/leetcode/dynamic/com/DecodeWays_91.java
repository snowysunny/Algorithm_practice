package leetcode.dynamic.com;

import java.util.Arrays;

/**
 * Time: 2019-05-25
 * Author: snowy
 * Leetcode 91: Decode Ways
 * 找规律： 1 <= cur <= 6    pre = 1 || 2   res = dp[n - 1] + dp[n - 2]
 *          1 <= cur <= 6    pre = 0 || [3, 9]   res = dp[n - 1]
 *          cur = 0                         res = dp[n - 2]
 *          cur >= 7        pre = 1     res = dp[n - 1] + dp[n - 2]
 *          cur >= 7        pre = 0 || [2, 9]   res = dp[n - 1]
 * */

public class DecodeWays_91 {
    public static int numDecodings(String s) {
        if(s == null || s.length() < 0)
            return 0;
        if(s.charAt(0) == '0')
            return 0;

        int[] dp = new int[s.length()];
        dp[0] = 1;

        for(int i = 1; i < s.length(); i ++) {
            if(s.charAt(i) == '0') {
                if(s.charAt(i - 1) >= '3' || s.charAt(i - 1) == '0')
                    return 0;
                else if(i == 1)
                    dp[i] = dp[i - 1];
                else
                    dp[i] = dp[i - 2];

            }

            else {
                char temp = s.charAt(i) >= '7' ? '2' : '3';

                if(s.charAt(i - 1) >= temp || s.charAt(i - 1) == '0')
                    dp[i] = dp[i - 1];
                else {
                    if(i == 1)
                        dp[i] = dp[i - 1] + 1;
                    else
                        dp[i] = dp[i - 1] + dp[i - 2];
                }
            }

        }

        return dp[s.length() - 1];
    }

    public static void main(String[] args) {
        String s = "1002";
        int res = numDecodings(s);
        System.out.println(res);
    }
}

