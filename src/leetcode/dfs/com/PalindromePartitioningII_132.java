package leetcode.dfs.com;

import java.util.ArrayList;
import java.util.List;

/**
 * Time: 2019-07-04
 * Author: snowy
 * Leetcode 132: Palindrome Partitioning II
 * */

public class PalindromePartitioningII_132 {

    /**
     * 这道题是一道动态规划的题，使用下面的dfs的方法做会超时
     * */
    public static int count;

    public static int minCut(String s) {
        count = Integer.MAX_VALUE;
        backTrack(s, 0, new ArrayList<>());
        return count;
    }

    public static void backTrack(String s, int index, List<String> path) {
        if(path.size() > 0 && index >= s.length()) {
            count = Math.min(path.size() - 1, count);
            return;
        }

        for(int i = index; i < s.length(); i ++) {
            if(isPalindrome(s, index, i)) {
                path.add(s.substring(index, i + 1));
                backTrack(s, i + 1, path);
                path.remove(path.size() - 1);
            }
        }
    }


    public static boolean isPalindrome(String s, int left, int right) {
        if(left == right)
            return true;

        while(left < right) {
            if(s.charAt(left) != s.charAt(right))
                return false;
            right --;
            left ++;
        }

        return true;
    }


    //  动态规划的解法
    public static int minCut_dynamic(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        int[] min = new int[n];

        for(int i = 0; i < n; i ++) {
            min[i] = i;


            for(int j = 0; j <= i; j ++) {
                if(s.charAt(i) == s.charAt(j) && (i - 1 < j + 1 || dp[j + 1][i - 1])) {
                    dp[j][i] = true;
                    min[i] = j == 0 ? 0 : Math.min(min[i], min[j - 1] + 1);
                }
            }
        }

        return min[n - 1];
    }

    public static void main(String[] args) {
        String s = "ababababababababababababcbababa";
        
        int res = minCut(s);
        System.out.println(res);
    }
}
