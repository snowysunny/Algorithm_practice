package special_topic.tree;

/**
 * 时间复杂度为O(n)，空间复杂度为O(1)的中序、先序、后序遍历
 * */

import java.util.ArrayList;
import java.util.List;

public class MorrisTravel {

    // morris
    /**
     * 中序遍历
     * 1. 如果当前结点的左孩子为null，则输出当前结点，并将指针意移向当前结点的右孩子
     * 2. 如果当前结点的左孩子不为空，在当前结点的左子树上找到当前结点的在中序遍历下的前驱节点
     * （a） 如果前驱节点的右孩子为空，将该前驱节点的右孩子设置为当前结点。当前结点指向当前结点的左孩子
     * （b） 如果前驱节点的右孩子为当前结点，将它的右孩子重新设为null（恢复原来的树）。输出当前结点。当前结点的更新为当前结点的右孩子
     * 3. 重复1/2直到当前结点为空
     * */
    public static List<Integer> inorderMorrirsTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null)
            return res;
        TreeNode cur = root, prev = null;

        while(cur != null) {
            if(cur.left == null) {              // 如果当前结点的左孩子为null，记录当前结点，并将当前结点更新为当前结点的右结点
                res.add(cur.val);
                cur = cur.right;
            } else {                            // 如果当前结点的左孩子不为null，则取寻找当前结点的前驱结点
                prev = cur.left;
                while(prev.right != null && prev.right != cur) {        // 找到当前结点左子树上的最右边的那个结点，并且最右边那个结点的右指针不能只想当前结点
                    prev = prev.right;
                }
                if(prev.right == null) {        // 找到左子树的最右孩子啦
                    prev.right = cur;           // 将左子树的最右孩子的右指针指向当前结点
                    cur = cur.left;             // 将当前结点更新为当前结点的左孩子
                } else {
                    prev.right = null;          // 当前结点的左子树的最右结点的右指针已经指向了当前结点了，则将其重新置为null
                    res.add(cur.val);           // 记录下当前结点， 并且当前结点更新为当前结点的右子树
                    cur = cur.right;
                }
            }
        }
        return res;
    }

    /**
     * 先序遍历
     * 1. 如果当前结点的左孩子为null，则输出当前结点，并将指针意移向当前结点的右孩子
     * 2. 如果当前结点的左孩子不为空，在当前结点的左子树上找到当前结点的在中序遍历下的前驱节点
     * （a） 如果前驱节点的右孩子为空，将该前驱节点的右孩子设置为当前结点。输出当前结点（这里是和中序遍历唯一不同的地方），当前结点指向当前结点的左孩子
     * （b） 如果前驱节点的右孩子为当前结点，将它的右孩子重新设为null（恢复原来的树）。当前结点的更新为当前结点的右孩子
     * 3. 重复1/2直到当前结点为空
     * */
    public static List<Integer> preorderMorrisTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null)
            return res;
        TreeNode cur = root, prev = null;

        while(cur != null) {
            if(cur.left == null) {
                res.add(cur.val);
                cur = cur.right;
            } else{
                prev = cur.left;
                while(prev.right != null && prev.right != cur) {
                    prev = prev.right;
                }
                if(prev.right == null) {
                    prev.right = cur;
                    res.add(cur.val);
                    cur = cur.left;
                } else {
                    prev.right = null;
                    cur = cur.right;
                }
            }

        }

        return res;
    }

    // 后序遍历算法有点复杂，需要建立一个临时节点dump，令其左孩子是root。并且还需要一个子过程，就是倒序输出某两个节点之间路径上的各个节点。（之后再看吧，这边先简单实现一下吧）

    /**
     * 后序遍历
     * 当前节点设置为临时节点dump。
     * 1. 如果当前节点的左孩子为空，则将其右孩子作为当前节点。
     * 2. 如果当前节点的左孩子不为空，在当前节点的左子树中找到当前节点在中序遍历下的前驱节点。
     *    a) 如果前驱节点的右孩子为空，将它的右孩子设置为当前节点。当前节点更新为当前节点的左孩子。
     *    b) 如果前驱节点的右孩子为当前节点，将它的右孩子重新设为空。倒序输出从当前节点的左孩子到该前驱节点这条路径上的所有节点。当前节点更新为当前节点的右孩子。
     * 3. 重复以上1、2直到当前节点为空。
     * */

    public static void reverse(TreeNode from, TreeNode to) {
        if(from == to)
            return;

        TreeNode x = from, y = from.right;
        TreeNode z;
        while(true) {
            z = y.right;
            y.right = x;
            x = y;
            y = z;
            if(x == to)
                break;
        }
    }

    public static void printReverse(TreeNode from, TreeNode to) {
        reverse(from, to);

        TreeNode p = to;
        while(true) {
            System.out.println(p.val);
            if(p == from)
                break;
            p = p.right;
        }
        reverse(to, from);
    }

    // 这部分和中序遍历很像
    public static void postorderMorrisTraversal(TreeNode root) {
        TreeNode dump = new TreeNode(0);        // 比中序遍历多了一个结点dump
        dump.left = root;

        TreeNode cur = dump, prev = null;

        while(cur != null) {
            if(cur.left == null) {
                cur = cur.right;
            } else {
                prev = cur.left;
                while(prev.right != null && prev.right != cur) {
                    prev = prev.right;
                }
                if(prev.right == null) {
                    prev.right = cur;
                    cur = cur.left;
                } else {
                    printReverse(cur.left, prev);
                    prev.right = null;
                    cur = cur.right;
                }
            }
        }
    }


    public static void main(String[] args) {
        String str = "{6, 2, 7, 1, 4, null, 9, null, null, 3, 5, 8}";
        TreeNode root = TreeNode.stringToTreeNode(str);
        List<Integer> inorder = inorderMorrirsTraversal(root);
        System.out.println(inorder);
        List<Integer> preorder = preorderMorrisTraversal(root);
        System.out.println(preorder);
        postorderMorrisTraversal(root);
        TreeNode.postOrder(root);
    }
}
