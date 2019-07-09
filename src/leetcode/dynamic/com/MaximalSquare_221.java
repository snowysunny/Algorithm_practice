package leetcode.dynamic.com;

import java.util.Arrays;

/**
 * Time: 2019-06-16
 * Author: snwoy
 * Leetcode 221: Maximal Square
 * */

public class MaximalSquare_221 {

    public static int maximalSquare(char[][] matrix) {

        if(matrix == null || matrix.length < 1 || matrix[0].length < 1)
            return 0;

        int[][] maxarea = new int[matrix.length][matrix[0].length];

        int max = 0;
        for(int i = 0; i < matrix.length; i ++) {
            maxarea[i][0] = matrix[i][0] - '0';
            max = Math.max(max, maxarea[i][0]);
        }


        for(int i = 0; i < matrix[0].length; i ++) {
            maxarea[0][i] = matrix[0][i] - '0';
            max = Math.max(max, maxarea[0][i]);
        }


        for(int i = 1; i < matrix.length; i ++) {
            for(int j = 1; j < matrix[0].length; j ++) {
                if(matrix[i][j] == '1') {
                    maxarea[i][j] = Math.min(maxarea[i - 1][j - 1], Math.min(maxarea[i - 1][j], maxarea[i][j - 1])) + matrix[i][j] - '0';
                    max = Math.max(max, maxarea[i][j]);
                } else
                    maxarea[i][j] = 0;

            }
        }

        return max * max;
    }

    public static void main(String[] args) {
        char[][] matrix = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        int res = maximalSquare(matrix);
        System.out.println(res);
    }
}
