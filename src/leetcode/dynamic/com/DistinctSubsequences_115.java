package leetcode.dynamic.com;

import java.util.Arrays;

/**
 * Time: 2019-06-22
 * Author: snowy
 * Leetcode 115: Distinct Subsequences
 * */

public class DistinctSubsequences_115 {

    public static int numDistinct(String s, String t) {
        if(s == null || s.length() < 1)
            return 0;
        if(t == null || t.length() < 1)
            return 1;

        int[][] dp = new int[t.length() + 1][s.length() + 1];
        Arrays.fill(dp[0], 1);

        for(int i = 1; i <= t.length(); i ++) {
            for(int j = 1; j <= s.length(); j ++) {
                if(t.charAt(i - 1) == s.charAt(j - 1)) {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j - 1];         // 这里需要注意是前一行的前一列与当前行的前一列的和， 因为需要确保的是t[i-1] 与 s[j - 1]的关系
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }

        return dp[t.length()][s.length()];
    }

    public static void main(String[] args) {
        String s = "rabbbit";
        String t = "rabbit";
        int res = numDistinct(s, t);
        System.out.println(res);
    }
}
