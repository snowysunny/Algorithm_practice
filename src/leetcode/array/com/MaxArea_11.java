package leetcode.array.com;

/**
 * Time: 2019-04-26
 * Author: snowy
 * leetcode 11:  Container With Most Water， 双指针的一道题目，和3Sum，4Sum的思想上还是有重叠的
 * */

public class MaxArea_11 {
    public static int maxArea(int[] height) {
        if(height == null || height.length < 2)
            return 0;
//        记录位置
        int left = 0, right = height.length - 1;
        int maxSum = 0;

        while(left <right) {
            maxSum = Math.max(Math.min(height[left], height[right]) * (right - left), maxSum);
            if(height[left] < height[right])
                left ++;
            else
                right --;
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] heights = {1,8,6,2,5,4,8,3,7};
        int sum = maxArea(heights);
        System.out.println(sum);
    }
}
