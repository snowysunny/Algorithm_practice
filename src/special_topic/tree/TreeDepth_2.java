package special_topic.tree;

/**
 * Time: 2019-07-12
 * Author: snowy
 * 树的深度—— 1.树的高度   2. 树的最小高度
 * */

public class TreeDepth_2 {
    public static int maxDepth(TreeNode root) {
        if(root == null)
            return 0;

        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public static int minDepth(TreeNode root) {
        if(root == null)
            return 0;

        int left = minDepth(root.left);
        int right = minDepth(root.right);

        return (left == 0 || right == 0) ? left + right + 1 : Math.min(left, right) + 1;
    }

    public static void main(String[] args) {
        String rootStr = "[5,4,8,11,null,13,4,7,2,null,null,null,1]";
        TreeNode root = TreeNode.stringToTreeNode(rootStr);
        int res = maxDepth(root);
        System.out.println(res);
        int mindepth = minDepth(root);
        System.out.println(mindepth);
    }
}
