package leetcode.stack.com;

/**
 * Time: 2019-05-17
 * Author: snowy
 * Leetcode 71: Simlify Path
 * 思路： 使用栈
 *       1. 首先将字符串按照'/'进行切分
 *       2. 当遇到""或者"."时，直接跳过
 *       3. 当遇到".."时如果栈不为空，则弹出栈中的一个元素，若栈为空，则跳过
 *       4. 其他字符进行进栈操作
 * */

import java.util.Arrays;
import java.util.Stack;

public class SimplifyPath_71 {

    public static String simplifyPath(String path) {
        if(path == null || path.equals(""))
            return path;
        String[] pathSplit = path.split("/");           // 将字符串按照'/'进行切分

        Stack<String> stack = new Stack<>();

        for(int i = 0; i < pathSplit.length; i ++) {
            if(pathSplit[i].equals("") || pathSplit[i].equals("."))         // 当遇到""或者"."时，直接跳过
                continue;
            if(pathSplit[i].equals("..")) {         // 当遇到".."时如果栈不为空，则弹出栈中的一个元素，若栈为空，则跳过
                if(stack.isEmpty())
                    continue;
                else
                    stack.pop();
            } else                                      // 其他字符进行进栈操作
                stack.push(pathSplit[i]);
        }
        StringBuffer sb = new StringBuffer();
        while(!stack.isEmpty()) {
            sb.insert(0, "/" + stack.peek());
            stack.pop();
        }
        if(sb.length() == 0)
            sb.append("/");

        return sb.toString();
    }

    public static void main(String[] args) {
        String path = "/a//b////c/d//././/..";
        String res = simplifyPath(path);
        System.out.println(res);
    }
}
