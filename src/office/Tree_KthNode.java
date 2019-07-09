package office;

/**
 * Time: 2019-04-18
 * Author: snowy
 * Link: https://www.nowcoder.com/practice/ef068f602dde4d28aab2b210e859150a?tpId=13&tqId=11215&tPage=4&rp=4&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * 二叉搜索树的第k个结点
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。例如， （5，3，7，2，4，6，8）    中，按结点数值大小顺序第三小结点的值为4。
 * */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Tree_KthNode {

    public static TreeNode KthNode(TreeNode pRoot, int k) {

        Stack<TreeNode> stack = new Stack<>();

        TreeNode curr = pRoot;
        TreeNode res = null;

        while(curr != null || !stack.isEmpty()) {

            // 先将左结点压栈
            while(curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            // 逐个出栈，将结点添加到res中，并将其右孩子结点入栈
            curr = stack.pop();
            k --;
            if(k == 0) {
                res = curr;
                break;
            }
            curr = curr.right;
        }


        return res;
    }

    public static void main(String[] args) {
        String node = "{5,3,7,2,4,6,8}";
        TreeNode root = TreeNode.StringToTreeNode(node);

        TreeNode res = KthNode(root, 3);
        System.out.println(res.val);


        Integer[] numbers = {1, 2, 3, 4, 5, 6};
        List<Integer> list = Arrays.asList(numbers);
        System.out.println(list.get(0));
    }
}
