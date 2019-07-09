package office;

import java.util.ArrayList;

/**
 * Time: 2019-04-03
 * Author: snowy
 * Link: https://www.nowcoder.com/practice/b736e784e3e34731af99065031301bca?tpId=13&tqId=11177&tPage=2&rp=2&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * 二叉树中和为某一值的路径    （这道题参考Leetcode的 113. Path Sum II [https://leetcode.com/problems/path-sum-ii/] ）
 * 输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)
 * */

public class Tree_PathSum {
    public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();              // 用于保存结果

        PathSumHelper(res, new ArrayList<Integer>(), root, target);
        return res;
    }

    public static void PathSumHelper(ArrayList<ArrayList<Integer>> list, ArrayList<Integer> curNode, TreeNode root, int target) {

        if(root == null)
            return;

        curNode.add(root.val);          // 保存当前的节点

        if (root.left == null && root.right == null) {   // 判断是否是叶子结点
            if(root.val == target)          // 叶子结点与残差正好相等则将其加入到结果中去
                list.add(curNode);
        } else {            // 不是叶子结点
            PathSumHelper(list, new ArrayList<>(curNode), root.left, target - root.val);         // 左右结点递归使用
            PathSumHelper(list, new ArrayList<>(curNode), root.right, target - root.val);
        }
    }

    public static void main(String[] args) {
        String StringRoot = "{5, 4, 8, 11, null, 9, 4, 7, 2, null, null, 5, 1}";
        TreeNode root = TreeNode.StringToTreeNode(StringRoot);
        ArrayList<ArrayList<Integer>> res = FindPath(root, 22);

        for(ArrayList<Integer> list: res){
            System.out.println(list);
        }

    }

}
