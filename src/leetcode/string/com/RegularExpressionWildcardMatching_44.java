package leetcode.string.com;

/**
 * Time: 2019-05-17
 * Author: snowy
 * Leetcode 44: Wildcard Matching
 * */

public class RegularExpressionWildcardMatching_44 {
    public static boolean isMatch(String s, String p) {
        if(s == null && p == null)
            return false;

        return isMatchCore(s, p, 0, 0);
    }

    public static boolean isMatchCore(String s, String p, int sIndex, int pIndex) {
        if(sIndex >= s.length() && pIndex >= p.length())
            return true;
        if(sIndex != s.length() && pIndex >= p.length())
            return false;

        if(p.charAt(pIndex) == '*') {
            if(sIndex < s.length())
                return isMatchCore(s, p, sIndex, pIndex + 1) || isMatchCore(s, p, sIndex + 1, pIndex) || isMatchCore(s, p, sIndex + 1, pIndex + 1);
            else
                return isMatchCore(s, p, sIndex, pIndex + 1);
        }

        if(sIndex < s.length() && (p.charAt(pIndex) == s.charAt(sIndex) || p.charAt(pIndex) == '?'))
            return isMatchCore(s, p, sIndex + 1, pIndex + 1);

        return false;
    }

    // 使用动态规划的方法做，帮助提高效率，时间复杂度O(nm)   与递归的思想项类似，不过是从后向前进行遍历
    public static boolean isMatch_iter(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[s.length()][p.length()] = true;

        for(int i = s.length(); i >= 0; i --) {
            for(int j = p.length() - 1; j >= 0; j --) {

                if(p.charAt(j) == '*') {
                    if(i < s.length()) {
                        dp[i][j] = dp[i + 1][j] || dp[i][j + 1] || dp[i][j];
                    } else {
                        dp[i][j] = dp[i][j + 1];
                    }
                }

                if(i < s.length() && (p.charAt(j) == s.charAt(i) || p.charAt(j) == '?'))
                    dp[i][j] = dp[i + 1][j + 1];
            }
        }

        return dp[0][0];
    }


    public static void main(String[] args){
        String s = "acdcb";
        String p = "a*b";
        boolean res = isMatch_iter(s, p);
        System.out.println(res);
    }
}
