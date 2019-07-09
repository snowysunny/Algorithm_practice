package leetcode.array.com;

import java.util.Arrays;

/**
 * Time: 2019-05-07
 * Author: snowy
 * Leetcode 48: Rotate Image
 * 找规律的题目
 * */

public class RotateImage_48 {
    public static void rotate(int[][] matrix) {
        if(matrix == null)
            return;

        int len = matrix.length;
        for(int i = 0; i <= len / 2; i ++) {
            for(int j = i; j < len - i - 1; j ++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[len - 1 - j][i];                               // 左下 -> 左上
                matrix[len - 1 - j][i] = matrix[len - 1 - i][len - 1 - j];           // 右下 -> 左下
                matrix[len - 1 - i][len - 1 - j] = matrix[j][len - 1 - i];          // 右上 -> 右下
                matrix[j][len - 1 - i] = temp;                                      // 左上 -> 右上
            }
//            System.out.println(Arrays.toString(matrix[i]));
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        rotate(matrix);
        for(int i = 0; i < matrix.length; i ++)
            System.out.println(Arrays.toString(matrix[i]));
    }
}
