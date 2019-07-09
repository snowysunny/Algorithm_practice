package leetcode.sort.com;

import java.util.Arrays;

/**
 * Time: 2019-06-03
 * Author: snowy
 * Leetcide 88: Merge Sorted Array
 * */

public class MergeSortedArray_88 {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int end1 = m - 1, end2 = n - 1;
        while(end1 >= 0 && end2 >= 0) {
            if(nums1[end1] >= nums2[end2]){
                nums1[end1 + end2 + 1] = nums1[end1];
                end1 --;
            } else {
                nums1[end1 + end2 + 1] = nums2[end2];
                end2 --;
            }
        }
        if(end1 < 0) {
            for(int i = end2; i >= 0; i --)
                nums1[i] = nums2[i];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        int m = 3, n = 3;
        merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }
}
