package leetcode.string.com;

import java.util.Stack;

/**
 * Time: 2019-04-29
 * Author: snowy
 * leetcode 20:  Valid Parentheses
 * */

public class ValidParentheses_20 {
    public static boolean isValid(String s) {
        if (s == "" || s == null || s.length() < 1)
            return true;
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if(c == '{' || c == '[' || c == '(')
                stack.push(c);
            else if (c == '}') {
                if(!stack.isEmpty() && stack.peek() == '{')
                    stack.pop();
                else
                    return false;
            } else if(c == ']') {
                if(!stack.isEmpty() && stack.peek() == '[')
                    stack.pop();
                else
                    return false;
            } else if(c == ')') {
                if(!stack.isEmpty() && stack.peek() == '(')
                    stack.pop();
                else
                    return false;
            } else
                return false;
        }

        if(!stack.isEmpty())
            return false;

        return true;
    }

    public static void main(String[] args) {
        String s = "{}{}{[()]}";
        boolean res = isValid(s);
        System.out.println(res);
    }
}
