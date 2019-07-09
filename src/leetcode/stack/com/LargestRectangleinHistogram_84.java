package leetcode.stack.com;

import java.util.Stack;

/**
 * Time: 2019-06-15
 * Author: snowy
 * Leetcode 84: Largest Rectangle in Histogram
 * */

public class LargestRectangleinHistogram_84 {
    public static int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();

        stack.push(-1);
        int max = 0;
        for(int i = 0; i < heights.length; i ++) {

            // 当heights[i] <= heights[i - 1] 时，计算前面的数据构成矩阵的最大值
            while(stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {
                max = Math.max(max, heights[stack.pop()] * (i - stack.peek() -1));
            }

            // 当heights[i] > heights[i - 1]是直接将heights[i]进展
            stack.push(i);
        }

        while(stack.peek() != -1)
            max = Math.max(max, heights[stack.pop()] * (heights.length - stack.peek() - 1));

        return max;
    }

    public static void main(String[] args) {
        int[] heights = {6, 7, 5, 2, 4, 5, 9, 3};
        int height = largestRectangleArea(heights);
        System.out.println(height);
    }
}
