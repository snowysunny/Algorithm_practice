package leetcode.tree.com;

import java.util.ArrayList;
import java.util.List;

/**
 * Time: 2019-05-28
 * Author: snowy
 * Leetcode 98: Path Sum II
 * 深度优先搜索的思想
 * */

public class PathSum2_113 {

    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null)
            return res;

        pathSumCore(root, sum, new ArrayList<>(), res);

        return res;
    }

    public static void pathSumCore(TreeNode root, int sum, List<Integer> path, List<List<Integer>> res) {

        if(root == null)
            return;

        path.add(root.val);

        if(root.left == null && root.right == null && sum == root.val) {
            res.add(new ArrayList<>(path));
        } else {
            pathSumCore(root.left, sum - root.val, path, res);
            pathSumCore(root.right, sum - root.val, path, res);
        }

        path.remove(path.size() - 1);

    }

    public static void main(String[] arggs) {
        String input = "[5,4,8,11,null,13,4,7,2,null,null,5,1]";
        TreeNode root = TreeNode.stringToTreeNode(input);
        List<List<Integer>> res = pathSum(root, 22);
        for(List<Integer> list : res)
            System.out.println(list);
    }

}
