package leetcode.dfs.com;

/**
 * Time: 2019-06-07
 * Author: snowy
 * Leetcode 200: Number of Islands
 * 这道题是字节跳动夏令营的笔试题
 * */

public class NumberofIslands_200 {
    public static int numIslands(char[][] grid) {
        if(grid == null || grid.length < 1 || grid[0].length < 1)
            return 0;

        int res = 0;

        for(int i = 0; i < grid.length; i ++) {
            for(int j = 0; j < grid[0].length; j ++) {
                if(grid[i][j] == '1') {
                    changeFlag(grid, i, j);
                    res ++;
                }
            }
        }

        return res;
    }

    public static void changeFlag(char[][] grid, int row, int col) {
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length)
            return;

        if(grid[row][col] == '0')
            return;

        if(grid[row][col] == '1') {
            grid[row][col] = '0';
        }

        // 改变周围的取值
        changeFlag(grid, row - 1, col);
        changeFlag(grid, row + 1, col);
        changeFlag(grid, row, col - 1);
        changeFlag(grid, row, col + 1);
    }

    public static void main(String[] args) {
//        char[][] grid = {{'1', '1', '1', '1', '0'},
//                {'1', '1', '0', '1', '0'},
//                {'1', '1', '0', '0', '0'},
//                {'0', '0', '0', '0', '0'}};

        char[][] grid = {{'1', '1', '0', '0', '0'},
                         {'1', '1', '0', '0', '0'},
                         {'0', '0', '1', '0', '0'},
                         {'0', '0', '0', '1', '1'}};
        int res = numIslands(grid);
        System.out.println(res);
    }
}
