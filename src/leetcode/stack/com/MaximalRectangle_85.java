package leetcode.stack.com;

import java.util.Stack;

/**
 * Time: 2019-06-19
 * Author: snowy
 * Leetcode 85:  Maximal Rectangle
 * 这道题是在第84题的基础上完成的，按行进行遍历，就能获得与第84题一样的矩阵题
 * */

public class MaximalRectangle_85 {


    public static int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length < 1 || matrix[0].length < 1)
            return 0;

        int[] height = new int[matrix[0].length];

        int max = 0;
        for(int i = 0; i < matrix.length; i ++) {
            for(int j = 0; j < matrix[0].length; j ++) {
                if(matrix[i][j] == '1')
                    height[j] ++;
                else
                    height[j] = 0;
            }
            max = Math.max(max, largestRectangleArea(height));
        }

        return max;
    }


    public static int largestRectangleArea(int[] height) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int max = 0;
        for(int i = 0; i < height.length; i ++) {
            while(stack.peek() != -1 && height[stack.peek()] >= height[i]) {
                max = Math.max(max, height[stack.pop()] * ( i - stack.peek() - 1));
            }
            stack.push(i);
        }
        while(stack.peek() != -1)
            max = Math.max(max, height[stack.pop()] * (height.length - stack.peek() - 1));

        return max;
    }

    public static void main(String[] args) {
        int[] height = {2,1,5,6,2,3};
        int res = largestRectangleArea(height);
        System.out.println(res);
    }
}
