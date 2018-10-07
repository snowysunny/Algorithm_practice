package mz.array.com;

import java.util.ArrayList;
import java.util.List;

/**
 * Time: 2018-10-07    Author: Snowy
 * LeetCode 442:  找出数组中所有重复项
 * */

public class FindDuplicates {

    // 时间复杂度：O(n)    空间复杂度： O(1)
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i ++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) {
                result.add(Math.abs(index + 1));
            }
            nums[index] = -nums[index];
        }
        for (int num: nums) {
            System.out.print(num + ", ");
        }
        System.out.println("");
        return result;
    }

    // 时间复杂度：O(n)    空间复杂度： O(1)
    public List<Integer> findDuplicates2(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i ++) {
            nums[(nums[i] - 1) % nums.length] += nums.length;   // 将原数组当成hash来使用，出现过的数字对应的下标位置上加上数组长度
        }
        for (int i = 0; i < nums.length; i ++) {
            if (nums[i] > 2 * nums.length)
                result.add(i + 1);
        }
        return result;
    }


    public List<Integer> findDuplicates3(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        int []temp = new int[nums.length];
        for (int num: nums) {
            temp[num - 1] += 1;
        }
        for (int i = 0; i < nums.length; i ++) {
            if (temp[i] == 2)
                result.add(i + 1);
        }

        return result;
    }



    public static void main(String[] args) {
        FindDuplicates fd = new FindDuplicates();
        int []nums = new int[]{10,2,5,10,9,1,1,4,3,7};
        List<Integer> result= fd.findDuplicates3(nums);
        for (int i = 0; i < result.size(); i ++) {
            System.out.println(result.get(i));
        }
    }
}
