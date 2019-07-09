package leetcode.dynamic.com;

/**
 * Time: 2019-05-16
 * Author: snowy
 * Leetcode 64: Minimum Path Sum
 * */

public class Path_MinimumPathSum_64 {
    public static int minPathSum(int[][] grid) {
        if(grid.length < 1 || grid[0].length < 1)
            return 0;
        int[][] res = new int[grid.length][grid[0].length];
        res[0][0] = grid[0][0];

        for(int row = 1; row < grid.length; row ++)
            res[row][0] = res[row - 1][0] + grid[row][0];

        for(int col = 1; col < grid[0].length; col ++)
            res[0][col] = res[0][col - 1] + grid[0][col];

        for(int row = 1; row < grid.length; row ++) {
            for(int col = 1; col < grid[0].length; col ++)
                res[row][col] = Math.min(res[row - 1][col], res[row][col - 1]) + grid[row][col];
        }

        return res[grid.length-1][grid[0].length - 1];
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        int res = minPathSum(grid);
        System.out.println(res);
    }
}
