package office;

import java.util.Stack;

/**
 * Time: 2019-04-02
 * Author: snowy
 * Link: https://www.nowcoder.com/practice/d77d11405cc7470d82554cb392585106?tpId=13&tqId=11174&tPage=2&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * 栈的压入、弹出序列
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 * */

public class Stack_IsPopOrder {

    public static boolean IsPopOreder(int[] pushA, int[] popA) {
        // 都为空是返回true
        if(pushA == null && popA == null)
            return true;

        // 其中之一不为空，返回false
        if(pushA == null || popA == null || pushA.length != popA.length)
            return false;

        boolean result = true;

        Stack<Integer> stack = new Stack<>();

        int popIndex = 0;
        for(int i = 0; i < pushA.length; i ++){     // 遍历pushA中的元素
            if(pushA[i] == popA[popIndex]) {      // 如果pushA中的元素与popA当前的节点是相同的就让popA的指针向后移一次,否则直接压栈
                popIndex++;
                while(!stack.isEmpty()) {           // 判断是否需要连续出栈
                    if(popA[popIndex] == stack.peek()) {
                        stack.pop();
                        popIndex ++ ;
                    }
                    else
                        break;
                }
            }
            else
                stack.push(pushA[i]);
        }
        if(!stack.isEmpty())
            result = false;

        return result;
    }

    public static void main(String[] args) {
        int[] pushA = {1, 2, 3, 4, 5};
        int[] popA = {4, 5, 3, 2, 1};
        boolean result = IsPopOreder(pushA, popA);
        System.out.println(result);
    }
}
