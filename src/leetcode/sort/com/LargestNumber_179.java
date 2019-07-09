package leetcode.sort.com;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Time: 2019-07-02
 * Author: snowy
 * Leetcode 179: Largest Number
 * */

public class LargestNumber_179 {

    public static String largestNumber(int[] nums) {
        if(nums == null || nums.length < 1)
            return "";

        String[] numStr = new String[nums.length];
        for(int i = 0; i < nums.length; i ++) {
            numStr[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(numStr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String num1 = o1 + o2;
                String num2 = o2 + o1;
                return num2.compareTo(num1);
            }
        });

        String res = "";

        for(String str : numStr)
            res += str;

        if(res.charAt(0) == '0')
            res = "0";

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {3,30,34,5,9};
        String res = largestNumber(nums);
        System.out.println(res);
    }
}
