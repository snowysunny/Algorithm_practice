package special_topic.tree;

/**
 * Time: 2019-07-16
 * Author: snowy
 * 剑指offer：二叉树的下一个结点 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 * */

class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}


public class GetNext_18 {

    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        if(pNode == null)
            return pNode;
        if(pNode.right == null && pNode.next == null)
            return null;


        if(pNode.right != null) { // 右子树不为空，那么寻找右子树的最左结点
            pNode = pNode.right;
            while(pNode.left != null)
                pNode = pNode.left;
        } else {                  // 右子树为空,找父节点，如果当前结点是父节点的左孩子，那么父结点就是下一个结点
            if(pNode.next.left == pNode)
                pNode = pNode.next;
            else {                // 如果当前结点是父节点的右孩子，那么就去找第一个作为左孩子的祖先节点
                while(pNode.next != null && pNode.next.left != pNode) {
                    pNode = pNode.next;
                }
                pNode = pNode.next;
            }

        }

        return pNode;
    }

    public static void main(String[] args) {
    }
}


