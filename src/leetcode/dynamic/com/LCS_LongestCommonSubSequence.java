package leetcode.dynamic.com;

import java.util.Arrays;

/**
 * Time: 2019-07-09
 * Author: snowy
 * 最大公共子序列
 * */

public class LCS_LongestCommonSubSequence {

    public static int[][] findLongestSubStringDP(String str1, String str2) {
        int[][] dp = new int[str1.length()][str2.length()];

        for(int col = 0; col < str2.length(); col ++) {
            if(str1.charAt(0) == str2.charAt(col))
                dp[0][col] = 1;
            else
                dp[0][col] = col == 0 ? 0 : dp[0][col - 1];
        }

        for(int row = 0; row < str1.length(); row ++) {
            if(str1.charAt(row) == str2.charAt(0))
                dp[row][0] = 1;
            else
                dp[row][0] = row == 0 ? 0 : dp[row - 1][0];
        }

        for(int row = 1; row < str1.length(); row ++) {
            for(int col = 1; col < str2.length(); col ++) {
                if(str1.charAt(row) == str2.charAt(col)) {
                    dp[row][col] = Math.max(dp[row - 1][col - 1] + 1, Math.max(dp[row - 1][col], dp[row][col - 1]));
                } else {
                    dp[row][col] = Math.max(dp[row - 1][col], dp[row][col - 1]);
                }
            }
        }

        return dp;
    }

    public static String LCS(String str1, String str2, int[][] dp) {
        StringBuffer buffer = new StringBuffer();

        int row = str1.length() - 1, col = str2.length() - 1;

        int length = dp[row][col];

        while(length > 0) {
            if(row > 0 && dp[row][col] == dp[row - 1][col])
                row --;
            else if(col > 0 && dp[row][col] == dp[row][col - 1])
                col --;
            else {
                buffer.append(str1.charAt(row));
                row --;
                col --;
                length --;
            }
        }

        return String.valueOf(buffer.reverse());
    }

    public static void main(String[] args){
        String str1 = "ACCGGTCGAGTGCGCGGAAGCCGGCCGAA"; // "1A2C3D4B56";
        String str2 = "GTCGTTCGGAATGCCGTTGCTCTGTAAA"; //"B1D23CA45B6A";


        int[][] dp = findLongestSubStringDP(str1, str2);

        String ans = LCS(str1, str2, dp);
        System.out.println(ans);
    }
}
