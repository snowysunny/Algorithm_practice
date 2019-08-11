package special_topic.listNode;

/**
 * Time: 2019-07-17
 * Author: snowy
 * 两个结点是否相交
 * */

public class IsIntersect_15 {
    public static boolean isIntersect(ListNode head1, ListNode head2) {
        if(head1 == null || head2 == null)
            return false;

        while(head1.next != null) {
            head1 = head1.next;
        }

        while(head2.next != null)
            head2 = head2.next;

        return head1 == head2;
    }
}
