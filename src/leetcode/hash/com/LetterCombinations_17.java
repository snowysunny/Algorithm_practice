package leetcode.hash.com;

import java.util.ArrayList;
import java.util.List;

/**
 * Time: 2019-04-30
 * Author: snowy
 * leetcode 17: Letter Combinations of a Phone Number
 * */

public class LetterCombinations_17 {
    public static ArrayList<String> letterCombinations(String digits) {
        ArrayList<String> res = new ArrayList<>();
        if(digits.length() < 1 || digits == null || digits.trim().equals(""))
            return res;

        char[][] letters = {{'a', 'b', 'c'},
                            {'d', 'e', 'f'},
                            {'g', 'h', 'i'},
                            {'j', 'k', 'l'},
                            {'m', 'n', 'o'},
                            {'p', 'q', 'r', 's'},
                            {'t', 'u', 'v'},
                            {'w', 'x', 'y', 'z'}};

        for (int i = 0; i < letters[digits.charAt(0) - 50].length; i ++) {
            res.add("" + letters[digits.charAt(0) - 50][i]);                // 获取第一个数字对应的字符
        }


        for(int i = 1; i < digits.length(); i ++) {
            ArrayList<String> list = res;            // 辅助数组
            res = new ArrayList<>();
            for(int j = 0; j < list.size(); j ++) {
                for(int k = 0; k < letters[digits.charAt(i) - 50].length; k ++) {
                    res.add(list.get(j) + letters[digits.charAt(i) - 50][k]);
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        String digits = "23";
        List<String> res = letterCombinations(digits);
        System.out.println(res);
    }
}
