package leetcode.math.com;

import java.util.Arrays;

/**
 * Time: 2019-05-18
 * Author: snowy
 * Leetcode 43: Multiply Strings
 * */

public class MultiplyStrings_43 {
    public static String multiply(String num1, String num2) {
        if(num1 == null || num1.equals("") || num2 == null || num2.equals(""))
            return "";

        int len1 = num1.length(), len2 = num2.length();

        int[] res = new int[len1 + len2];

        for(int i = 0; i < len1; i ++) {

            for(int j = 0; j < len2; j ++) {
                int cur = (num1.charAt(len1 - 1 - i) - 48) * (num2.charAt(len2 - 1 - j) - 48);

                // 包含进位和当前位的更新计算
                res[i + j + 1] += (res[i + j] + cur) / 10;
                res[i + j] = (res[i + j] + cur) % 10;

            }
        }

        int start = len1 + len2 - 1;
        while(start >= 0 && res[start] == 0)
            start --;

        StringBuffer sb = new StringBuffer();
        for(int i = start; i >= 0; i --)
            sb.append(res[i]);

        if (sb.toString().equals(""))
            return "0";

        return sb.toString();
    }

    public static void main(String[] args) {
        String num1 = "2";
        String num2 = "0";
        String res = multiply(num1, num2);
        System.out.println(res);
    }
}
