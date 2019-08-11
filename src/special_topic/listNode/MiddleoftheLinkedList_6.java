package special_topic.listNode;

/***
 * Time: 2019-07-17
 * Author: snowy
 * Leetcode 876: Middle of the Linked List   寻找中间节点，如果序列长度为偶数，则返回第二个结点
 * 使用快慢指针，快指针每步走两个，满指针每步走一格
 */

public class MiddleoftheLinkedList_6 {
    public static ListNode middeleNode(ListNode head) {
        if(head == null || head.next == null)
            return head;

        ListNode slow = head;
        ListNode fast = head.next;

        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow.next;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        ListNode head = ListNode.arrayToListNode(array);
        ListNode node = middeleNode(head);
        System.out.println(ListNode.listNodeToList(node));
    }
}
