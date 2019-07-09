package leetcode.string.com;

/**
 * Time: 2018-05-01
 * Author: snowy
 * Leetcode 22: Generate Parentheses
 * */

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis_22 {
    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if(n <= 0)
            return res;

        int left = n, right = n;
        dfsHelper(left, right, res, "");
        System.out.println(res);
        return res;
    }

    public static void dfsHelper(int left, int right, List<String> result, String strs) {
       if(left > right)
           return;

       if(left == 0 && right == 0) {
           result.add(strs);
           return;
       }
       if(left > 0)
           dfsHelper(left-1, right, result, strs + "(");
       if(right > 0)
           dfsHelper(left, right-1, result, strs + ")");
    }

    public static void main(String[] args) {
        int n = 3;
        List<String> res = generateParenthesis(n);
        System.out.println(res);
    }

}
