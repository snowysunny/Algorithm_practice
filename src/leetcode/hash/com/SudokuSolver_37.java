package leetcode.hash.com;

import java.util.Arrays;

public class SudokuSolver_37 {
    public static void solveSudoku(char[][] board) {
        if(board == null)
            return;
        solve(board);
    }

    public static boolean solve(char[][] board) {
        for(int i = 0; i < board.length; i ++) {
            for(int j = 0; j < board[0].length; j ++) {
                if(board[i][j] == '.') {
                    for(char c = '1'; c <= '9'; c ++) {
                        if(isValid(board, i, j, c)) {
                            board[i][j] = c;

                            if(solve(board))
                                return true;
                            else
                                board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    // 确定board[row][col]是否能够填充c
    public static boolean isValid(char[][] board, int row, int col, char c) {
        for(int i = 0; i < board.length; i ++) {
            if(board[row][i] == c)
                return false;
            if(board[i][col] == c)
                return false;
            if(board[row/3 * 3 + i / 3][col/3 * 3 + i %3] == c)
                return false;
        }
        return true;
    }



    public static void main(String[] args) {
        char[][] board =  { {'5','3','.','.','7','.','.','.','.'},
                            {'6','.','.','1','9','5','.','.','.'},
                            {'.','9','8','.','.','.','.','6','.'},
                            {'8','.','.','.','6','.','.','.','3'},
                            {'4','.','.','8','.','3','.','.','1'},
                            {'7','.','.','.','2','.','.','.','6'},
                            {'.','6','.','.','.','.','2','8','.'},
                            {'.','.','.','4','1','9','.','.','5'},
                            {'.','.','.','.','8','.','.','7','9'}};

        solveSudoku(board);
        for(int i = 0; i < board.length; i ++) {
            System.out.println(Arrays.toString(board[i]));
        }
    }
}
