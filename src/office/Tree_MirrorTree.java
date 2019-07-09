package office;

import static office.TreeNode.StringToTreeNode;

/**
 * Time: 2019-04-02
 * Author: snowy
 * Link: https://www.nowcoder.com/practice/564f4c26aa584921bc75623e48ca3011?tpId=13&tqId=11171&tPage=1&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * 二叉树的镜像
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 * */

public class Tree_MirrorTree {

    public static void Mirror(TreeNode root) {
        // 如果root为空或者没有子结点则直接返回
        if(root == null || (root.left == null && root.right == null))
            return;

        // 交换左右子结点
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        // 左右子结点进行递归求镜像
        Mirror(root.left);
        Mirror(root.right);
    }

    public static void main(String[] args) {

        String stringTree = "[8, 6, 10, 5, 7, 9, 11]";
        TreeNode root = StringToTreeNode(stringTree);

        TreeNode.inorder_iter(root);
        Mirror(root);
        TreeNode.inorder_iter(root);
    }
}
