package leetcode.array.com;

import java.util.Arrays;

public class GameofLife_289 {

    public static void gameOfLife(int[][] board) {
        if(board == null || board.length < 1 || board[0].length < 1)
            return;
        int rows = board.length, cols = board[0].length;

        int[][] sum = new int[rows][cols];

        for(int row = 0; row < rows; row ++) {
            for(int col = 0; col < cols; col ++) {
                for(int i = row - 1; i <= row + 1 && i < rows; i ++) {
                    for(int j = col - 1; j <= col + 1 && j < cols; j ++ ){
                        if(i < 0 || j < 0)
                            continue;
                        sum[row][col] += board[i][j];
                    }
                }
                sum[row][col] -= board[row][col];
            }
        }

        for (int row = 0; row < rows; row ++) {
            for(int col = 0; col < cols; col ++) {
                if(sum[row][col] == 3)
                    board[row][col] = 1;
                else if(sum[row][col] == 2)
                    board[row][col] = board[row][col];
                else
                    board[row][col] = 0;
            }
        }

    }

    public static void main(String[] args) {
        int[][] board = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        gameOfLife(board);
    }
}
