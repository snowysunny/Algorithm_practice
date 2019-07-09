package leetcode.string.com;

/**
 * Time: 2019-04-29
 * Author: snowy
 * leetcode 10:  Regular Expression Matching
 * */


public class RegularExpressionMatching_10 {

    public static boolean isMatchHelper(String s, String p, int sStart, int pStart) {
        if(sStart >= s.length() && pStart >= p.length())
            return true;
        if(sStart != s.length() && pStart >= p.length())
            return false;


        if(pStart + 1 < p.length() && p.charAt(pStart + 1) == '*') {
            if (sStart < s.length() && (s.charAt(sStart) == p.charAt(pStart) || p.charAt(pStart) == '.') )
                return isMatchHelper(s, p, sStart, pStart + 2) || isMatchHelper(s, p, sStart + 1, pStart) || isMatchHelper(s, p, sStart + 1, pStart + 2);
            else
                return isMatchHelper(s, p, sStart, pStart + 2);
        }


        if(sStart != s.length() && s.charAt(sStart) == p.charAt(pStart) || (p.charAt(pStart) == '.' && sStart != s.length()))
            return isMatchHelper(s, p, sStart + 1, pStart + 1);

        return false;
    }

    public static boolean regularExpressionMatching(String s, String p) {
        if(s == null || p == null)
            return false;
        return isMatchHelper(s, p, 0, 0);
    }

    // 使用动态规划的方法做，帮助提高效率，时间复杂度O(nm)
    public static boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[s.length()][p.length()] = true;

        for(int i = s.length(); i >= 0; i --) {
            for(int j = p.length() - 1; j >= 0; j --) {
                boolean firstMatch = (i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'));
                if(j + 1 < p.length() && p.charAt(j + 1) == '*') {
                    dp[i][j] = dp[i][j + 2] || firstMatch && (dp[i + 1][j + 2] || dp[i + 1][j]);    // 与的顺序不能颠倒
                } else {
                    dp[i][j] = firstMatch && dp[i + 1][j + 1];           // 与的顺序不能颠倒
                }
            }
        }

        return dp[0][0];
    }


    public static void main(String[] args) {
        String s = "a";
        String p = ".*..a*";
        boolean res = regularExpressionMatching(s, p);
        System.out.println(res);
    }
}
