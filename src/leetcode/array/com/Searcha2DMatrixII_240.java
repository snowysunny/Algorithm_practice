package leetcode.array.com;

/**
 * Time: 2019-06-21
 * Author: snowy
 * Leetcode 240: Search a 2D Matrix II
 * */

public class Searcha2DMatrixII_240 {

    public static boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length < 1 || matrix[0].length < 1)
            return false;

        int row = 0, col = matrix[0].length - 1;

        while(row < matrix.length && col >= 0) {
            if(matrix[row][col] == target)
                return true;
            else if(matrix[row][col] > target)
                col --;
            else
                row ++;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {  {1,   4,  7, 11, 15},
                            {2,   5,  8, 12, 19},
                            {3,   6,  9, 16, 22},
                            {10, 13, 14, 17, 24},
                            {18, 21, 23, 26, 30}
                        };

        int target = 20;
        boolean res = searchMatrix(matrix, target);
        System.out.println(res);

    }
}
