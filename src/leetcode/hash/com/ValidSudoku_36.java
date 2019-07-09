package leetcode.hash.com;

import java.util.HashSet;
import java.util.Set;

/**
 * Time: 2019-05-04
 * Author: snowy
 * Leetcode 36: Valid Sudoku
 * */

public class ValidSudoku_36 {

    public static boolean isValidSudoku(char[][] board) {
        Set<String> set = new HashSet<>();
        String rows = "%s in row %s";
        String cols = "%s in col %s";
        String block = "%s in block %s-%s";

        for(int i = 0; i < board.length; i ++) {
            for(int j = 0; j < board[0].length; j ++) {
                if(board[i][j] == '.')
                    continue;
                if(set.contains(String.format(rows, board[i][j], i)) || set.contains(String.format(cols, board[i][j], j)) || set.contains(String.format(block, board[i][j], i/3, j/3)))
                    return false;

                set.add(String.format(rows, board[i][j], i));
                set.add(String.format(cols, board[i][j], j));
                set.add(String.format(block, board[i][j], i/3, j/3));
            }
            System.out.println(set);
        }

        return true;
    }

    public static void main(String[] args) {
        char[][] board =  { {'.','.','.','.','5','.','.','1','.'},
                            {'.','4','.','3','.','.','.','.','.'},
                            {'.','.','.','.','.','3','.','.','1'},
                            {'8','.','.','.','.','.','.','2','.'},
                            {'.','.','2','.','7','.','.','.','.'},
                            {'.','1','5','.','.','.','.','.','.'},
                            {'.','.','.','.','.','2','.','.','.'},
                            {'.','2','.','9','.','.','.','.','.'},
                            {'.','.','4','.','.','.','.','.','.'}};

        boolean res = isValidSudoku(board);
        System.out.println(res);
    }
}
