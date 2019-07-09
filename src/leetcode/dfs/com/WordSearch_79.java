package leetcode.dfs.com;

/**
 * Time: 2019-05-022
 * Author: snowy
 * Leetcode 77: Word Search
 * */

public class WordSearch_79 {
    public static boolean exist(char[][] board, String word) {
        if(board == null || board.length < 1 || board[0].length < 1)
            return false;

        boolean[][] visited = new boolean[board.length][board[0].length];

        for(int i = 0; i < board.length; i ++) {
            for(int j = 0; j < board[i].length; j ++) {
                if(existCore(board, word, i , j, 0, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean existCore(char[][] board, String word, int row, int col, int index, boolean[][] visited) {
        if(index ==word.length())
            return true;

        if(row < 0 || row >= board.length || col < 0 || col >= board[row].length)
            return false;

        if(board[row][col] != word.charAt(index) || visited[row][col] == true)
            return false;

        visited[row][col] = true;
        boolean exist = existCore(board, word, row + 1, col, index + 1, visited)
                     || existCore(board, word, row - 1, col, index + 1, visited)
                     || existCore(board, word, row, col - 1, index + 1, visited)
                     || existCore(board, word, row, col + 1, index + 1, visited);
        visited[row][col] = false;

        return exist;
    }

    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String[] words = {"ABCCED", "SEE", "ABCB"};
        for(String word : words) {
            boolean res = exist(board, word);
            System.out.println(res);
        }

    }
}
