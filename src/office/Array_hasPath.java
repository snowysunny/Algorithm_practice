package office;

import java.util.Arrays;

public class Array_hasPath {

    public static boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if(matrix == null || str == null || rows < 1 || cols < 1 || matrix.length!=rows*cols)
            return false;

        boolean[] visited = new boolean[rows * cols];
        int pathLength = 0;

        for(int row = 0; row < rows; row ++) {
            for(int col = 0; col < cols; col ++) {
                if(hasPathCore(matrix, rows, cols, str, row, col, pathLength, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean hasPathCore(char[] matrix, int rows, int cols, char[] str, int row, int col, int pathLength, boolean[] visited) {
        if(pathLength >= str.length)
            return true;

        boolean hasPath = false;

        if(row >= 0 && row < rows && col >= 0 && col < cols && matrix[row * cols + col] == str[pathLength] && !visited[row * cols + col]) {
            pathLength ++;
            visited[row * cols + col] = true;
            // 上下左右
            hasPath = hasPathCore(matrix, rows, cols, str, row-1, col, pathLength, visited)
                    || hasPathCore(matrix, rows, cols, str, row+1, col, pathLength, visited)
                    || hasPathCore(matrix, rows, cols, str, row, col + 1, pathLength, visited)
                    || hasPathCore(matrix, rows, cols, str, row, col - 1, pathLength, visited);

            if(!hasPath) {
                pathLength --;
                visited[row * cols + col] = false;
            }
        }
        return hasPath;
    }

    public static void main(String[] args){
        String strs = "abcesfcsadee";
        char[] matrix = strs.toCharArray();

        String target = "bcced";
        char[] str = target.toCharArray();

        boolean res = hasPath(matrix, 3, 4, str);

        System.out.println(res);
    }
}
