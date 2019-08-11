package special_topic.listNode;

/**
 * Time: 2019-07-17
 * Author: snowy
 * Leetcode 86: Partition List
 */

public class PartitionList_7 {
    public static ListNode partition(ListNode head, int x) {
        if(head == null)
            return head;

        ListNode leftpart = new ListNode(0);
        ListNode rightpart = new ListNode(0);
        ListNode left = leftpart;
        ListNode right = rightpart;

        while(head != null) {
            if(head.val < x) {
                left.next = head;
                left = left.next;
            } else {
                right.next = head;
                right = right.next;
            }
            head = head.next;
        }
        right.next = null;
        left.next = rightpart.next;

        return leftpart.next;
    }

    public static void main(String[] args) {

    }
}