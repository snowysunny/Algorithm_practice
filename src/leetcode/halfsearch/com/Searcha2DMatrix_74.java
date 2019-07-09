package leetcode.halfsearch.com;

/**
 * Time: 2019-05-19
 * Author: snowy
 * Leetcode 74: Search a 2D Matrix
 * */

public class Searcha2DMatrix_74 {
    public static boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length < 1 || matrix[0].length < 1)
            return false;

        int row = 0, col = matrix[0].length - 1;

        while(row < matrix.length && col >= 0) {
            if(matrix[row][col] == target)
                return true;
            else if (matrix[row][col] < target)
                row ++;
            else
                col --;
        }

        return false;
    }

    // 二维转一维进行计算
    public static boolean searchMatrix_half(int[][] matrix, int target) {
        if(matrix == null || matrix.length < 1 || matrix[0].length < 1)
            return false;

        int rows = matrix.length, cols = matrix[0].length;

        int left = 0, right = rows * cols - 1;

        while(left <= right) {
            int mid = (left + right) / 2;
            int curVal = matrix[mid / cols][mid % cols];

            if(curVal == target)
                return true;
            else if(curVal < target)
                left = mid + 1;
            else
                right = mid - 1;
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
        int target = 3;
        boolean res = searchMatrix_half(matrix, target);
        System.out.println(res);
    }
}
