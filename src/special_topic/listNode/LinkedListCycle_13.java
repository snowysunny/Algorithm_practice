package special_topic.listNode;

/**
 * Time: 2019-07-17
 * Author: snowy
 * Leetcode 141: Linked List Cycle
 * // 判断链表是否存在环，使用快慢指针
 * */

public class LinkedListCycle_13 {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null)
            return false;

        ListNode slow = head;
        ListNode fast = head.next;

        while(slow != fast) {
            if(fast == null || fast.next == null)
                return false;
            slow = slow.next;
            fast = fast.next.next;
        }

        return true;
    }
}
