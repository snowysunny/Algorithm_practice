package leetcode.array.com;

import java.util.Arrays;

/**
 * Time: 2019-05-21
 * Author: snowy
 * Leetcode 66: Plus One
 * */

public class PlusOne_66 {
    public static int[] plusOne(int[] digits) {
        for(int i = digits.length - 1; i >= 0; i --) {
            digits[i] = digits[i] + 1;
            int carry = digits[i] / 10;
            digits[i] = digits[i] % 10;
            if(carry == 0)
                return digits;
        }
        int[] arr = new int[digits.length + 1];
        arr[0] = 1;
        return arr;
    }

    public static void main(String[] args) {
        int[] digits = {4, 3, 2, 9};
        int[] arr = plusOne(digits);
        System.out.println(Arrays.toString(arr));
    }
}
