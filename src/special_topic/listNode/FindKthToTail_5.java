package special_topic.listNode;

/**
 * Time: 2019-07-17
 * Author: snowy
 * 链表中倒数第k个结点
 * */

public class FindKthToTail_5 {
    public static ListNode findKthToTail(ListNode head, int k) {
        if(head == null || k < 1)
            return null;

        ListNode fast = head;
        ListNode slow = head;
        int count = 1;

        while(count < k && fast != null) {
            fast = fast.next;
            count ++;
        }
        if(fast == null)
            return null;

        while(fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }

    public static void main(String[] args) {

    }
}
