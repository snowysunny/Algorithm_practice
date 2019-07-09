package leetcode.tree.com;

/**
 * Time: 2019-06-14
 * Author: snowy
 * Leetcode 337: House Robber III
 * 递归的方法
 * */

public class HouseRobberIII_337 {

    public static int rob(TreeNode root) {
        if(root == null)
            return 0;

        int[] res = dfs(root);
        return Math.max(res[0], res[1]);
    }

    public static int[] dfs(TreeNode root) {

        // res[0]中保存不包含根节点的和， res[1]中保存包含了根节点的和
        int[] res = new int[2];

        if(root == null)
            return res;

        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);     //不包含根节点，最大值为两个子树的最大值之和
        res[1] = left[0] + right[0] + root.val;         //包含根节点，最大值为两个子树不包含根节点的最大值加上根节点的值

        return res;
    }

    public static void main(String[] args) {
        String treeStr = "[3,4,5,1,6,null,1]";
        TreeNode root = TreeNode.stringToTreeNode(treeStr);
        int res = rob(root);
        System.out.println(res);
    }
}
