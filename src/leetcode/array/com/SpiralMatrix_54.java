package leetcode.array.com;

import java.util.ArrayList;
import java.util.List;

/**
 * Time: 2019-05-12
 * Author: snowy
 * Leetcode 54: Spiral Matrix
 * */

public class SpiralMatrix_54 {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if(matrix == null)
            return res;
        int rows = matrix.length, cols = matrix[0].length;
        boolean[][] isVisited = new boolean[rows][cols];

        int direction = 1;
        int count = 0, i = 0, j = 0;
        while(count < rows * cols) {
            // 向右
            if (direction == 1) {
                if(j < cols && isVisited[i][j] == false) {
                    isVisited[i][j] = true;
                    res.add(matrix[i][j ++]);
                    count ++;
                } else {
                    direction = 2;
                    i ++;
                    j --;
                }
            } else if(direction == 2) {     // 向下
                if(i < rows && isVisited[i][j] == false) {
                    isVisited[i][j] = true;
                    res.add(matrix[i ++][j]);
                    count ++;
                } else {
                    direction = 3;
                    j --;
                    i --;
                }
            } else if(direction == 3) {     // 向左
                if(j >= 0 && isVisited[i][j] ==false) {
                    isVisited[i][j] = true;
                    res.add(matrix[i][j --]);
                    count ++;
                } else {
                    direction = 4;
                    i --;
                    j ++;
                }
            } else {                        // 向上
                if(i >= 0 && isVisited[i][j] ==false) {
                    isVisited[i][j] = true;
                    res.add(matrix[i --][j]);
                    count ++;
                } else {
                    direction = 1;
                    j ++;
                    i ++;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] nums = {{1, 2, 3, 4},
                        {5,  6, 7, 8},
                        {9,  10, 11, 12}};
        List<Integer> res = spiralOrder(nums);
        System.out.println(res);
    }
}
