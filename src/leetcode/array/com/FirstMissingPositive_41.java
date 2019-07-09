package leetcode.array.com;

/**
 * Time: 2019-05-12
 * Author: snowy
 * Leetcode 41: First Missing Positive
 * 思路： 将数组长度范围内的数放到对应的位置上，然后进行数组的遍历即可
 * */

public class FirstMissingPositive_41 {
    public static int firstMissingPositive(int[] nums) {
        if(nums.length < 1 || nums == null)
            return 1;
        int i = 0;
        while(i < nums.length) {            // 归位，将在[0, nums.length]范围上的数字安排到对应的位置上
            if(nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            } else {
                i ++;
            }
        }

        for(int j = 0; j < nums.length; j ++ ) {  // 遍历查看缺失的数值
            if(nums[j] != j + 1)
                return j + 1;
        }

        return nums.length + 1;     // 没有缺失的则返回长度+1
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int res = firstMissingPositive(nums);
        System.out.println(res);
    }
}
