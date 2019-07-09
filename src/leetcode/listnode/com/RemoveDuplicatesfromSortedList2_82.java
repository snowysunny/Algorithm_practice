package leetcode.listnode.com;

/**
 * Time: 2019-05-24
 * Author: snowy
 * Leetcode 82: Remove Duplicates from Sorted List II
 */


public class RemoveDuplicatesfromSortedList2_82 {
    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null)
            return head;
        ListNode node = new ListNode(0);
        ListNode result = node;
        while(head != null) {
            int data = head.val;
            if(head.next != null && head.next.val == data) {
                while(head.next != null && head.next.val == data)
                    head = head.next;
            } else {
                node.next = new ListNode(data);
                node = node.next;
            }
            head = head.next;
        }
        return result.next;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 3, 4, 4, 5};
        ListNode res = ListNode.arrayToListNode(arr);
        System.out.println(ListNode.listNodeToString(res));
    }
}
