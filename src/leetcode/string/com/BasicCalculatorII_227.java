package leetcode.string.com;

import java.util.Stack;

public class BasicCalculatorII_227 {

    public static int calculate(String s) {
        Stack<Integer> nums = new Stack<>();

        int num = 0;
        char sign = '+';
        for(int i = 0; i < s.length(); i ++) {
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                num = num * 10 + (s.charAt(i) - '0');
            }
            if(s.charAt(i) < '0' && s.charAt(i) != ' ' || i == s.length() - 1) {
                if(sign == '+')
                    nums.push(num);
                else if(sign == '-')
                    nums.push(-num);
                else if(sign == '*') {
                    int temp = nums.pop() * num;
                    nums.push(temp);
                } else {
                    int temp = nums.pop() / num;
                    nums.push(temp);
                }

                sign = s.charAt(i);
                num = 0;
            }
        }

        int res = 0;
        while(!nums.isEmpty()) {
            res += nums.pop();
        }

        return res;
    }

    public static void main(String[] args) {
        String s = "3+5 / 2";
        int res = calculate(s);
        System.out.println(res);
    }
}
