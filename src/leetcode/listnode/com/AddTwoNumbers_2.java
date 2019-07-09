package leetcode.listnode.com;

/**
 * Time: 2019-04-26
 * Author: snowy
 * leetcode 2: Add Two Numbers
 * */

public class AddTwoNumbers_2 {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        // 用于记录
        ListNode l3 = new ListNode(0);
        ListNode cur = l3;

        // 保存进位
        int carry = 0;

        while(l1 != null && l2 != null) {
            int values = l1.val + l2.val + carry;
            carry = values / 10;
            cur.next = new ListNode(values % 10);
            l1 = l1.next;
            l2 = l2.next;
            cur = cur.next;
        }
        while(l1 != null) {
            int values = l1.val + carry;
            carry = values / 10;
            cur.next = new ListNode(values % 10);
            l1 = l1.next;
            cur = cur.next;
        }
        while(l2 != null) {
            int values = l2.val + carry;
            carry = values / 10;
            cur.next = new ListNode(values % 10);
            l2 = l2.next;
            cur = cur.next;
        }
        // 别忘了最后还有进位
        if(l1 == null && l2 == null && carry != 0)
            cur.next = new ListNode(carry);

        return l3.next;
    }

    public static void main(String[] args) {
        int[] nodeNums1 = {5};
        int[] nodeNums2 = {5, 9};

        ListNode l1 = ListNode.arrayToListNode(nodeNums1);
        ListNode l2 = ListNode.arrayToListNode(nodeNums2);
        ListNode l3 = addTwoNumbers(l1, l2);
        String str3 = ListNode.listNodeToString(l3);
        System.out.println(str3);
    }
}
