package special_topic.listNode;

/**
 * Time: 2019--07-17
 * Author: snowy
 * Leetcode 142: Linked List Cycle II
 * */

public class LinkedListCycleII_14 {
    public static ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null)
            return null;

        ListNode slow = head;
        ListNode fast = head.next;

        while(fast != null && fast.next != null && slow != fast) {
            slow = slow.next;
            fast = fast.next.next;
        }

        if(fast == null || fast.next == null)
            return null;

        slow = slow.next;
        fast = head;

        while(slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
}
