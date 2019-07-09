package office;

/**
 * Time: 2019-04-19
 * Author: snowy
 * Link: https://www.nowcoder.com/practice/ff05d44dfdb04e1d83bdbdab320efbcb?tpId=13&tqId=11211&tPage=3&rp=4&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * 对称的二叉树
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 * */

public class TreeNode_isSymmetrical {
    public static boolean isSymmetrical(TreeNode pRoot) {
            return isSymmetrical(pRoot, pRoot);
    }

    public static boolean isSymmetrical(TreeNode pRoot1, TreeNode pRoot2) {
        if(pRoot1 == null && pRoot2 == null)
            return true;
        if(pRoot1 == null || pRoot2 == null)
            return false;
        if(pRoot1.val != pRoot2.val)
            return false;

        return isSymmetrical(pRoot1.left, pRoot2.right) && isSymmetrical(pRoot1.right, pRoot2.left);
    }

    public static void main(String[] args){
        String nodes = "{8, 6, 6, 5, 7, 7, 5}";
        TreeNode root = TreeNode.StringToTreeNode(nodes);

        TreeNode.preorder(root);

        boolean res = isSymmetrical(root);
        System.out.println(res);
    }
}
