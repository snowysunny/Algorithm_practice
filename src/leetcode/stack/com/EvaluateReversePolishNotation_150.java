package leetcode.stack.com;

import java.util.Stack;

/**
 * Time: 2019-06-05
 * Author: snowy
 * Leetcode 150: Evaluate Reverse Polish Notation
 * 加减乘除的计算
 * */

public class EvaluateReversePolishNotation_150 {
    public static int evalRPN_2(String[] tokens) {
        if(tokens == null || tokens.length < 1)
            return 0;

        Stack<String> stack = new Stack<>();

        int res = 0;
        for(int i = tokens.length - 1; i >= 0; i --) {
            if(tokens[i] == "+" ||  tokens[i] == "-" || tokens[i] == "*" || tokens[i] == "/")
                stack.push(tokens[i]);
            else {
                if(stack.isEmpty() || stack.peek() == "+" ||  stack.peek() == "-" || stack.peek() == "*" || stack.peek() == "/")
                    stack.push(tokens[i]);
                else {
                    res = Integer.parseInt(tokens[i]);
                    while(!stack.isEmpty() && stack.peek() != "+" &&  stack.peek() != "-" && stack.peek() != "*" && stack.peek() != "/") {
                        int num = Integer.parseInt(stack.pop());
                        String op = stack.pop();
                        switch (op){
                            case "+":
                                res = res + num;
                                break;
                            case "-":
                                res = res - num;
                                break;
                            case "*":
                                res = res * num;
                                break;
                            case "/":
                                res = res / num;
                                break;
                        }
                    }
                    stack.push(String.valueOf(res));
                }
            }
        }

        return Integer.parseInt(stack.pop());

    }

    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int num1, num2;
        for(int i = 0; i < tokens.length; i ++) {
            switch (tokens[i]) {
                case "+":
                    num1 = stack.pop();
                    num2 = stack.pop();
                    stack.push(num1 + num2);
                    break;
                case "-":
                    num1 = stack.pop();
                    num2 = stack.pop();
                    stack.push(num2 - num1);
                    break;
                case "*":
                    num1 = stack.pop();
                    num2 = stack.pop();
                    stack.push(num1 * num2);
                    break;
                case "/":
                    num1 = stack.pop();
                    num2 = stack.pop();
                    stack.push(num2 / num1);
                    break;
                default:
                    stack.push(Integer.parseInt(tokens[i]));
            }
            System.out.println(stack);
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String[] tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*"};
        int res = evalRPN(tokens);
        System.out.println(res);
    }
}
