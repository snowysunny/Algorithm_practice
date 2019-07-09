package office;

/**
 * Time: 2019-04-11
 * Author: snowy
 * Link: https://www.nowcoder.com/practice/8b3b95850edb4115918ecebdf1b4d222?tpId=13&tqId=11192&tPage=2&rp=2&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * 平衡二叉树
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树
 * */

public class Tree_IsBalanced_Solution {

    /**
     * 使用递归的思想，就是想要好好的进行相关的
     * */
    public static boolean IsBalanced_Solution(TreeNode root) {
        if(root == null)
            return true;

        int left = TreeHeaight(root.left);
        int right = TreeHeaight(root.right);
        if(left - right > 1 || left - right < -1)
            return false;

        return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
    }

    public static int TreeHeaight(TreeNode root) {
        if (root == null)
            return 0;

        int left = TreeHeaight(root.left);
        int right = TreeHeaight(root.right);

        return Math.max(left, right) + 1;
    }

    /**
     * 从下向上遍历，如果子树是平衡二叉树，则返回树的高度，若果不是平衡二叉树，则直接停止遍历
     * */
    public static boolean IsBalanced(TreeNode root) {
        return BalancedTreeHeight(root) != -1;
    }

    public static int BalancedTreeHeight(TreeNode root) {
        if(root == null)
            return 0;

        int left = BalancedTreeHeight(root.left);
        if(left == -1)
            return -1;
        int right = BalancedTreeHeight(root.right);
        if(right == -1)
            return -1;

        return Math.abs(left - right) > 1 ? -1 : 1 + Math.max(BalancedTreeHeight(root.left), BalancedTreeHeight(root.right));
    }

    public static void main(String[] args) {
        String treeNode = "[1, 2, 3, 4, 5, null, 6, null, null, 7]";
        TreeNode root = TreeNode.StringToTreeNode(treeNode);

//        String stringRoot = "[8, 10, 6, 11, 9, 7, 5]";

        boolean res = IsBalanced_Solution(root);

        System.out.println(res);
    }
}
