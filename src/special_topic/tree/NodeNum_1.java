package special_topic.tree;

/**
 * Time: 2019-07-12
 * Author: snowy
 * 树中的节点个数
 * */

public class NodeNum_1 {
    public static int getNodeNumber(TreeNode root) {
        if(root == null)
            return 0;
        return getNodeNumber(root.left) + getNodeNumber(root.right) + 1;
    }

    public static void main(String[] args) {
        String rootStr = "[5,4,8,11,null,13,4,7,2,null,null,null,1]";
        TreeNode tree = TreeNode.stringToTreeNode(rootStr);
        int res = getNodeNumber(tree);
        System.out.println(res);
    }
}
