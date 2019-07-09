package leetcode.dfs.com;

import java.util.Arrays;

/**
 * Time: 2019-05-31
 * Author: snowy
 * Leetcode 130: Surrounded Regions
 * */

public class SurroundedRegions_130 {

    /**
     * 思路： 遍历在边上的'O'以及与之相连的'O'， 将它们标记为'M'，之后将不是'M'的标记为'X'
     * */

    public static void solve(char[][] board) {
        if(board == null)
            return;

        for(int i = 0; i < board.length; i ++) {                // 将边界上的'O'找出来
            for(int j = 0; j < board[0].length; j ++) {
                if((i == 0 || i == board.length - 1 || j == 0 || j == board[0].length - 1) && board[i][j] == 'O') {
                    board[i][j] = 'M';
                    helper(board, i, j);            // 修改与之相邻的''
                }
            }
        }

        for(int i = 0; i < board.length; i ++) {
            for (int j = 0; j < board[0].length; j ++) {
                if(board[i][j] == 'M')
                    board[i][j] = 'O';
                else
                    board[i][j] = 'X';
            }
        }
    }

    public static void helper(char[][] board, int i, int j) {
        if(i - 1 >= 0 && board[i-1][j] == 'O') {
            board[i - 1][j] = 'M';
            helper(board, i - 1, j);
        }

        if(i + 1 < board.length && board[i + 1][j] == 'O') {
            board[i + 1][j] = 'M';
            helper(board, i + 1, j);
        }

        if(j - 1 >= 0 && board[i][j - 1] == 'O') {
            board[i][j - 1] = 'M';
            helper(board, i, j - 1);
        }

        if(j + 1 < board[0].length && board[i][j + 1] == 'O') {
            board[i][j + 1] = 'M';
            helper(board, i, j + 1);
        }
    }

    public static void main(String[] args) {
        char[][] board = {{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
        solve(board);
        for(char[] row : board)
            System.out.println(Arrays.toString(row));
    }
}
