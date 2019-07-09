package leetcode.sort.com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Time: 2019-06-26
 * Author: snowy
 * Leetcode 315: Count of Smaller Numbers After Self
 * */

public class CountofSmallerNumbersAfterSelf_315 {

    // 归并排序， 根据nums的大小对nums元素所对应的的位置进行排序
    /**
     * @param nums: 原数组
     * @param smaller： 统计每个位置上逆序的结果
     * @param pos： 元素的位置
     * */
    public static void merge(int[] nums, int[] smaller, int[] pos, int[] copy, int start, int end) {
        if(start >= end)
            return;

        int mid = (start + end) / 2;

        merge(nums, smaller, pos, copy, start, mid);
        merge(nums, smaller, pos, copy, mid + 1, end);

//        int[] copy = new int[end + 1 - start];

        int left = start, right = mid + 1, jump = 0, leftcopy = start;
        while(left <= mid || right <= end) {
            if(left > mid) {
                jump ++;
                copy[leftcopy ++] = pos[right ++];
            } else if(right > end){
                smaller[pos[left]] += jump;
                copy[leftcopy ++] = pos[left ++];
            } else if(nums[pos[left]] <= nums[pos[right]]) {
                smaller[pos[left]] += jump;
                copy[leftcopy ++] = pos[left ++];
            } else {
                jump ++;
                copy[leftcopy ++] = pos[right ++];
            }
        }

        for(int i = start; i <= end; i ++)
            pos[i] = copy[i];
    }

    public static List<Integer> countSmaller(int[] nums) {
        int[] smaller = new int[nums.length];    // 记录结果的
        int[] pos = new int[nums.length];        // 记录位置
        for(int i = 0; i < pos.length; i ++)
            pos[i] = i;

//
        int[] copy = new int[nums.length];
        merge(nums, smaller, pos, copy, 0, nums.length-1);
//        sort(nums, smaller, pos,0, nums.length - 1);
        List<Integer> result = new ArrayList<>(nums.length);
        for(int i=0; i<nums.length; i++) result.add(smaller[i]);

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 0};
        List<Integer> result = countSmaller(nums);
        System.out.println(result);
    }
}
