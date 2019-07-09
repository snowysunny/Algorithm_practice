package leetcode.dynamic.com;

import java.util.Stack;

/**
 * Time: 2019-05-05
 * Author: snowy
 * Topic: match
 * Leetcode 32: Longest Valid Parentheses
 * */

public class Match_LongestValidParentheses_32 {

    public static int longestValidParentheses_dp(String s) {
        if(s.length() < 2 || s == "")
            return 0;
        int maxLength = 0;
        int[] dp = new int[s.length()];

        for(int i = 1; i < s.length(); i ++) {
            if(s.charAt(i) == ')') {
                if(s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if(i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + (i - dp[i - 1] >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
            }
            maxLength = Math.max(dp[i], maxLength);
        }

        return maxLength;
    }

    /**
     * Using stack
     * */
    public static int longestValidParentheses_stack(String s) {
        if(s.length() < 2 || s == "")
            return 0;
        int maxLength = 0;
        Stack<Integer> stack = new Stack<>();
        // 记录初始位置
        stack.push(-1);
        // 进行遍历
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(')
                stack.push(i);
            // 右括号需要进行处理
            if(s.charAt(i) == ')') {
                stack.pop();
                if(stack.isEmpty()) {
                    stack.push(i);
                }
                maxLength = Math.max(maxLength, i - stack.peek());
            }
        }

        return maxLength;
    }

    /**
     * Without extra space
     * */
    public static int longestValidParentheses(String s) {
        if(s.length() < 2 || s == "")
            return 0;

        int left = 0, right = 0, maxLength = 0;
        // 从左向右扫描
        for(int i = 0; i < s.length(); i ++) {
            if(s.charAt(i) == '(')
                left ++;
            if(s.charAt(i) == ')')
                right ++;
            if(left == right)
                maxLength = Math.max(maxLength, left + right);
            if (left < right)
                left = right = 0;
        }
        // 从右向左扫描
        left = right = 0;
        for(int i = s.length() - 1; i >= 0; i--) {
            if(s.charAt(i) == '(')
                left ++;
            if(s.charAt(i) == ')')
                right ++;
            if(left == right)
                maxLength = Math.max(maxLength, left + right);
            if(left > right)
                left = right = 0;
        }

        return maxLength;
    }

    public static void main(String[] args) {
        String s = ")()()((())()";
        int res = longestValidParentheses_dp(s);
        System.out.println(res);
    }
}
