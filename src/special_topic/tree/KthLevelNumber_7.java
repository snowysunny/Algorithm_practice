package special_topic.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 求二叉树第K层的节点个数
 * */

public class KthLevelNumber_7 {
    public static int get_k_level_number(TreeNode root, int k) {
        if(root == null || k == 0)
            return 0;

        if(root != null && k == 1)
            return 1;

        return get_k_level_number(root.left, k - 1) + get_k_level_number(root.right, k - 1);
    }

    public static int kLevelNumber(TreeNode root, int k) {
        if(root == null)
            return 0;

        List<Integer> res = new ArrayList<>();
        kLevelNumberCore(root, k, res);

        return res.size();
    }

    public static void kLevelNumberCore(TreeNode root, int k, List<Integer> res) {
        if(root == null)
            return;

        if(k == 1) {
            res.add(root.val);
            return;
        }

        kLevelNumberCore(root.left, k - 1, res);
        kLevelNumberCore(root.right, k - 1, res);

    }

    public static void main(String[] args) {
        String rootStr = "[5,4,8,11,null,13,4,7,2,null,null,null,1]";
        /**
         *                          5
         *                    4          8
         *                11         13      4
         *             7      2                  1
         */
        TreeNode root = TreeNode.stringToTreeNode(rootStr);
        int res = get_k_level_number(root, 4);
        System.out.println(res);

        int res1 = kLevelNumber(root, 2);
        System.out.println(res1);
    }
}
