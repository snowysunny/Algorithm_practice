package office;

import java.util.Scanner;

/**
 * Time: 2019-03-17
 * Author: snowy
 * Link: https://www.nowcoder.com/practice/abc3fe2ce8e146608e868a70efebf62e?tpId=13&tqId=11154&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * 二维数组中的查找
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * */

public class Array_FindTwoDimArray {
    public boolean Find(int target, int [][] array) {
        if (array == null)
            return false;
        int rows = 0;
        int cols = array[0].length;

        while(rows < array.length && cols > 0) {
            int start = array[rows][cols - 1];
            if (start == target)
                return true;
            else if (start > target)
                cols --;
            else
                rows ++;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Array_FindTwoDimArray ftda = new Array_FindTwoDimArray();



        int[][] array = {{1, 2, 3, 4},{5, 6, 7, 8},{9, 10, 11, 12},{13, 14, 15, 16}};
        int target = 0;
        boolean res = ftda.Find(target, array);
        System.out.println(res);
    }
}
