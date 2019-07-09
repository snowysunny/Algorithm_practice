package leetcode.math.com;

/**
 * Time: 2019-07-08
 * Author: snowy
 * Leetcode 171: Excel Sheet Column Number
 * */

public class ExcelSheetColumnNumber_171 {
    public static int titleToNumber(String s) {
        int res = 0;
        for(int i = 0; i < s.length(); i ++) {
            res = res * 26 + (s.charAt(i) - 'A' + 1);
        }

        return res;
    }

    public static void main(String[] args) {
        String s = "ZY";
        int res = titleToNumber(s);
        System.out.println(res);
    }
}
