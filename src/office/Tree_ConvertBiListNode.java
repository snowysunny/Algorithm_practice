package office;

import java.lang.management.PlatformLoggingMXBean;

/**
 * Time: 2019-04-04
 * Author: snowy
 * Link: https://www.nowcoder.com/practice/947f6eb80d944a84850b0538bf0ec3a5?tpId=13&tqId=11179&tPage=2&rp=2&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * 二叉搜索树与双向链表
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 * */

public class Tree_ConvertBiListNode {
    public static TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null)
            return null;
        if(pRootOfTree.left == null && pRootOfTree.right == null)
            return pRootOfTree;

        // 寻找左子树的第一个结点
        TreeNode left = Convert(pRootOfTree.left);

        TreeNode p = left;

        // 寻找中序遍历时左子树的最后一个结点
        while(p != null && p.right != null)
            p = p.right;

        // 如果左子树链表不为空的话，将当前root追加到左子树链表
        if(left != null) {
            p.right = pRootOfTree;
            pRootOfTree.left = p;
        }

        // 将右子树构造成双链表，并返回链表头节点
        TreeNode right = Convert(pRootOfTree.right);
        // 如果右子树链表不为空的话，将该链表追加到root节点之后
        if(right != null) {
           pRootOfTree.right = right;
           right.left = pRootOfTree;
        }

        return left != null ? left : pRootOfTree;
    }


    public static void main(String[] args) {

    }
}
