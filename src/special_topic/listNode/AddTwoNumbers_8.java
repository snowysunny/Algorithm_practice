package special_topic.listNode;

/**
 * Time: 2019-07-17
 * Author: snowy
 * Leetcode 2: Add Two Numbers
 * */

public class AddTwoNumbers_8 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;

        int carry = 0;
        int sum = 0;
        ListNode res = new ListNode(0);
        ListNode cur = res;

        while(l1 != null && l2 != null) {
            sum = l1.val + l2.val + carry;
            cur.next = new ListNode(sum % 10);
            carry = sum / 10;
            l1 = l1.next;
            l2 = l2.next;
            cur = cur.next;
        }

        while(l1 != null) {
            sum = l1.val + carry;
            cur.next = new ListNode(sum % 10);
            carry = sum / 10;
            l1 = l1.next;
            cur = cur.next;
        }
        while(l2 != null) {
            sum = l2.val + carry;
            cur.next = new ListNode(sum % 10);
            carry = sum / 10;
            l2 = l2.next;
            cur = cur.next;
        }

        if(carry != 0)
            cur.next = new ListNode(carry);

        return res.next;
    }
}
