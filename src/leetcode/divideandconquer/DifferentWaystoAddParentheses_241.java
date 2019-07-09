package leetcode.divideandconquer;

import java.util.ArrayList;
import java.util.List;

/**
 * Time: 2019-06-22
 * Author: snwoy
 * Leetcode 241: Different Ways to Add Parentheses
 * */

public class DifferentWaystoAddParentheses_241 {

    public static List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<>();
        if(input == null || input.length() < 1)
            return res;

        for(int i = 0; i < input.length(); i ++) {
            if(input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*') {
                String leftPart = input.substring(0, i);
                String rightPart = input.substring(i + 1, input.length());
                List<Integer> left = diffWaysToCompute(leftPart);       // 左边的数和符号能够构成的数
                List<Integer> right = diffWaysToCompute(rightPart);     // 右边的数和符号能够构成的数

                for(Integer leftval : left) {
                    for(Integer rightval : right) {
                        if(input.charAt(i) == '+')
                            res.add(leftval + rightval);
                        else if(input.charAt(i) == '-')
                            res.add(leftval - rightval);
                        else
                            res.add(leftval * rightval);
                    }
                }
            }
        }

        if(res.size() == 0)     // 如果输出为单个数字，那么直接添加进去
            res.add(Integer.valueOf(input));

        return res;
    }

    public static void main(String[] args) {
        String input = "2*3-4*5";
        List<Integer> res = diffWaysToCompute(input);
        System.out.println(res);
    }
}
