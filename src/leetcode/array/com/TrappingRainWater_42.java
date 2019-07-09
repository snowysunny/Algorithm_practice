package leetcode.array.com;

/**
 * Time: 2019-05-14
 * Author: snowy
 * Leetcode 42: Trapping Rain Water
 * */

public class TrappingRainWater_42 {
    public static int trap(int[] height) {
        if(height == null || height.length < 2)
            return 0;

        int left = 0, right = height.length - 1;
        int leftmax = 0, rightmax = 0;
        int sum = 0;

        while(left <= right) {
            if(leftmax <= rightmax) {
                if(leftmax > height[left])
                    sum += leftmax - height[left];
                else
                    leftmax = height[left];
                left ++;
            } else {
                if(rightmax > height[right])
                    sum += rightmax - height[right];
                else
                    rightmax = height[right];
                right --;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        int res = trap(height);
        System.out.println(res);
    }
}
