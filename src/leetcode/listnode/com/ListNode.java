package leetcode.listnode.com;

public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
    public static ListNode arrayToListNode(int []nodeValues) {

        ListNode pRoot = new ListNode(0);
        ListNode pre = pRoot;

        for(int node : nodeValues) {
            pre.next = new ListNode(node);
            pre = pre.next;
        }

        return pRoot.next;
    }

    public static String listNodeToString(ListNode node) {
        if (node == null) {
            return "[]";
        }

        String result = "";
        while (node != null) {
            result += Integer.toString(node.val) + ", ";
            node = node.next;
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

}
