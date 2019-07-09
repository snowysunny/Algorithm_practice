package leetcode.array.com;

import java.util.Arrays;

/**
 * Time: 2019-05-14
 * Author: snowy
 * Leetcode 59: Spiral Matrix II
 * */


public class SpiralMatrix2_59 {
    public static int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        boolean[][] isVisited = new boolean[n][n];
        if(n < 1)
            return res;

        int count = 1, row = 0, col = 0;
        int  direction = 1;
        while(count <= n * n) {
            if(direction == 1) {        // 向右
                if(col < n && isVisited[row][col] == false) {
                    res[row][col] = count;
                    isVisited[row][col] = true;
                    col ++;
                    count ++;
                } else {
                    direction = 2;
                    row ++;
                    col --;
                }
            } else if(direction == 2) {     // 向下
                if(row < n && isVisited[row][col] == false) {
                    res[row][col] = count;
                    isVisited[row][col] = true;
                    row ++;
                    count ++;
                } else {
                    direction = 3;
                    row --;
                    col --;
                }
            } else if(direction == 3) {     // 向左
                if(col >= 0 && isVisited[row][col] == false) {
                    res[row][col] = count;
                    isVisited[row][col] = true;
                    col --;
                    count ++;
                } else {
                    direction = 4;
                    col ++;
                    row --;
                }
            } else {
                if(row >= 0 && isVisited[row][col] == false) {
                    res[row][col] = count;
                    isVisited[row][col] = true;
                    row --;
                    count ++;
                } else {
                    direction = 1;
                    row ++;
                    col ++;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] res = generateMatrix(5);

        for (int[] ans:res)
            System.out.println(Arrays.toString(ans));
    }
}
