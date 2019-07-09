package office;

/**
 * Time: 2019-04-23
 * Author: snowy
 * Link: https://www.nowcoder.com/practice/6e5207314b5241fb83f2329e89fdecc8?tpId=13&tqId=11219&tPage=4&rp=4&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * 机器人的运动范围
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 * */

public class Array_movingCount {
    public static int movingCount(int threshold, int rows, int cols) {
        if(rows < 1 || cols < 1 || threshold < 1)
            return 0;
        boolean[] visited = new boolean[rows * cols];

        int count = movingCountCore(threshold, rows, cols, 0, 0, visited);
        return count;
    }

    public static int movingCountCore(int threshold, int rows, int cols, int row, int col, boolean[] visited) {
        int count = 0;

        if(row >= 0 && row < rows && col >= 0 && col < cols && getDigitSum(row) + getDigitSum(col) <= threshold && !visited[row * cols + col]) {
            visited[row * cols + col] = true;
            count = movingCountCore(threshold, rows, cols, row + 1, col, visited)
                    + movingCountCore(threshold, rows, cols, row + 1, col, visited)
                    + movingCountCore(threshold, rows, cols, row, col + 1, visited)
                    + movingCountCore(threshold, rows, cols, row, col - 1, visited) + 1;
        }
        return count;
    }


//    计算数的每位上的数和
    public static int getDigitSum(int num) {
        int sum = 0;
        while(num != 0) {
            sum += num % 10;
            num = num / 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        int threshold = 18;
        int res = movingCount(threshold, 40, 40);
        System.out.println(res);
    }
}
