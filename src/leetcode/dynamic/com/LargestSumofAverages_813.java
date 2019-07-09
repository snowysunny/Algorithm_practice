package leetcode.dynamic.com;

/**
 * Time: 2019-06-19
 * Author: snowy
 * Leetcode 2019-06-19
 * */

public class LargestSumofAverages_813 {

    public static double largestSumofAverages(int[] A, int K) {
        if(A == null || A.length < 1 || K < 1)
            return 0;

        int[] sum = new int[A.length + 1];
        double[][] dp = new double[A.length + 1][K + 1];

        for(int i = 1; i <= A.length; i ++) {
            sum[i] = sum[i - 1] + A[i - 1];
            dp[i][1] = sum[i] * 1.0 / i;
        }

        for(int i = 1; i <= A.length; i ++) {
            for(int k = 2; k <= K; k ++) {
                for(int j = 1; j < i; j ++) {
                    dp[i][k] = Math.max(dp[i][k], dp[j][k - 1] + (sum[i] - sum[j])/(1.0 * i - j));
                }
            }
        }

        return dp[A.length][K];
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5, 6, 7};
        int K = 4;
        double res = largestSumofAverages(A, K);
        System.out.println(res);
    }
}
