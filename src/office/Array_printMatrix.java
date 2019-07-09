package office;

/**
 * Time: 2019-04-02
 * Author: snowy
 * Link: https://www.nowcoder.com/practice/9b4c81a02cd34f76be2659fa0d54342a?tpId=13&tqId=11172&tPage=1&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * 顺时针打印矩阵
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 * */

import java.util.ArrayList;
import java.util.Arrays;

public class Array_printMatrix {
    public static ArrayList<Integer> printMatrix(int[][] matrix) {
        // 记录结果
        ArrayList<Integer> res = new ArrayList<>();

        int row = matrix.length, col = matrix[0].length;

        // 记录是否已经被访问过
        boolean[][] isVisit = new boolean[row][col];

        // 记录当前方向   方向的转变为： left2right -> up2down -> right2left -> down2up
        String direction = "left2right";

        // 已经访问过的元素的个数
        int visitedNum = 0;
        // 记录当前访问的行或者列
        int curRow = 0, curCol = 0;

        while(visitedNum < row * col) {

            if(direction == "left2right") {             // 当前访问方向从左到右

                if(curCol >= col || isVisit[curRow][curCol] == true) {          // 这两个条件的位置不能换，否则将会出数组越界的错
                    direction = "up2down";              // 右边没有未访问过的元素了或者到了右边界了则改变方向
                    curCol -- ;                         // 向左回一步
                    curRow ++;                          // 向下走一步
                } else {                                //右边还有没被访问过元素
                    res.add(matrix[curRow][curCol]);    // 将未访问的元素添加到结果序列中，并打上已访问过的标记， 访问过的元素数量加1，并且向右在走一步
                    isVisit[curRow][curCol] = true;
                    visitedNum ++;
                    curCol ++;
                }
            } else if(direction == "up2down") {     // 当前访问方向从上到下
                if(curRow >= row || isVisit[curRow][curCol] == true) {
                    direction = "right2left";           // 下面没有未被访问的元素了或者到了下边界了则改变方向
                    curRow --;                          // 向上走一步
                    curCol --;                          // 向左走一步
                } else {                                // 下边还有没被访问过的元素
                    res.add(matrix[curRow][curCol]);    // 将未访问的元素添加到结果序列中，并打上已访问过的标记， 访问过的元素数量加1，并且向下在走一步
                    isVisit[curRow][curCol] = true;
                    visitedNum ++;
                    curRow ++;
                }
            } else if(direction == "right2left") {      // 当前访问方向从右到左
                if(curCol < 0 || isVisit[curRow][curCol] == true) {
                    direction = "down2up";              // 左边没有未访问过的元素了或者到了左边界了则改变方向
                    curCol ++;                          // 向右回退一步
                    curRow --;                          // 向上走一步
                } else {                                // 左边还有没被访问过的元素
                    res.add(matrix[curRow][curCol]);    // 将未访问的元素添加到结果序列中，并打上已访问过的标记， 访问过的元素数量加1，并且向左在走一步
                    isVisit[curRow][curCol] = true;
                    visitedNum ++;
                    curCol --;
                }
            } else if(direction == "down2up") {     // 当前访问方向从下到上
                if(curRow < 0 || isVisit[curRow][curCol] == true) {
                    direction = "left2right";      // 上边没有未访问过的元素了或者到了上边界了则改变方向
                    curRow ++;
                    curCol ++;
                } else {
                    res.add(matrix[curRow][curCol]);
                    isVisit[curRow][curCol] = true;
                    visitedNum ++;
                    curRow --;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {5, 6, 7}, {9, 10, 11}, {13, 14, 15}};

        for(int i = 0; i < matrix.length; i ++) {
            System.out.println(Arrays.toString(matrix[i]));
        }

        ArrayList<Integer> res = printMatrix(matrix);

        System.out.println(res);

    }
}
