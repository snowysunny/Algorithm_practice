package leetcode.dynamic.com;

/**
 * Time: 2019-05-16
 * Author: snowy
 * Leetcode 62: Unique Paths
 * 这道题虽然是一道动态规划的题，其实是一道排列组合的题目，完完全全的数学题
 * */

public class Path_UniquePaths_62 {
    public static int uniquePaths(int m, int n) {
        if(m < 1 || n < 1)
            return 0;

        int[][] combine = new int[m + n - 1][m];
        combine[0][0] = 1;

        // 求组合数  C(n, k) = C(n - 1, k - 1) + C(n, k - 1)
        for(int i = 1; i < m + n - 1; i ++) {
            combine[i][0] = 1;
            for(int j = 1; j <= i  && j < m; j ++) {
                combine[i][j] = combine[i - 1][j - 1] + combine[i - 1][j];
            }
        }

        return combine[m + n - 2][m - 1];

    }

    public static void main(String[] args) {
        int m = 3, n = 2;
        int res = uniquePaths(m, n);
        System.out.println(res);
    }
}
