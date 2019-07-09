package leetcode.dynamic.com;

import java.util.ArrayList;
import java.util.List;

/**
 * Time: 2019-07-07
 * Author: snowy
 * Leetcode 334: Increasing Triplet Subsequence
 * */

public class LIS_IncreasingTripletSubsequence_334 {

    public static boolean increasingTriplet(int[] nums) {
        if(nums == null || nums.length < 3)
            return false;

        List<Integer> lis = new ArrayList<>();
        lis.add(nums[0]);

        for(int i = 1; i < nums.length; i ++) {
            if(nums[i] >= lis.get(lis.size() - 1))
                lis.add(nums[i]);
            else {
                int position = binarySearch(lis, nums[i]);
                lis.set(position, nums[i]);
            }

            System.out.println(lis);

            if(lis.size() >= 3)
                return true;
        }


        return false;
    }

    public static int binarySearch(List<Integer> sortedSeq, int num) {
        if(sortedSeq == null || sortedSeq.size() < 1)
            return 0;

        int left = 0, right = sortedSeq.size() - 1;

        while(left <= right) {
            int mid = (left + right) / 2;
            if(sortedSeq.get(mid) == num)
                return mid;
            if(sortedSeq.get(mid) > num)
                right = mid - 1;
            else
                left = mid + 1;
        }

        return left;
    }

    public static void main(String[] args) {
        int[] nums = {2,1,5,0,3};
        boolean res = increasingTriplet(nums);
        System.out.println(res);
    }
}
