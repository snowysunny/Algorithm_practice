package special_topic.sort;

import java.util.Arrays;
import java.util.Stack;

/**
 * Time: 2019-06-13
 * Author: snowy
 * 快速排序， 递归版本和非递归版本
 * */

public class QuickSort {
    private static void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public static int partitation(int[] nums, int left, int right) {
        int temp = nums[left];

        while(left < right) {
            while(left < right && nums[right] >= temp)
                right --;
            if(left < right)
                nums[left] = nums[right];
            while(left < right && nums[left] <= temp)
                left ++;
            if(left < right)
                nums[right] = nums[left];
        }

        nums[right] = temp;

        return left;
    }

    public static void QuickSort(int[] nums, int start, int end) {
        if(start >= end)
            return;

        int station = partitation(nums, start, end);
        QuickSort(nums, start, station - 1);
        QuickSort(nums, station + 1, end);
    }


    // 快排的非递归写法
    public static void QuickSort_iter(int[] nums, int left, int right) {
        if(nums == null || left >= right)
            return;

        Stack<Integer> stack = new Stack<>();
//        int left = 0, right = nums.length - 1;

        int i , j;

        // 注意顺序
        stack.push(left);
        stack.push(right);

        while(!stack.isEmpty()) {
            // 这里需要注意顺序呀
            j = stack.pop();            // 先弹出右指针
            i = stack.pop();            // 在弹出左指针

            if(i < j) {
                int station = partitation(nums, i, j);
                if(station > i) {
                    stack.push(i);
                    stack.push(station - 1);
                }
                if(station < j) {
                    stack.push(station + 1);
                    stack.push(j);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};
        System.out.println("排序前：" + Arrays.toString(nums));
        QuickSort_iter(nums, 0, nums.length - 1);
        System.out.println("排序后：" + Arrays.toString(nums));
    }
}
