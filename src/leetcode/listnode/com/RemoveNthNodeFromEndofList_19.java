package leetcode.listnode.com;

/**
 * Time: 2019-05-13
 * Author: snowy
 * Leetcode 19: Remove Nth Node From End of List
 * */

public class RemoveNthNodeFromEndofList_19 {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if(n < 1)
            return null;
        ListNode result = new ListNode(0);
        result.next = head;
        ListNode fast = result, slow = result;
        int count = 0;
        while(count < n && fast.next != null) {
            fast = fast.next;
            count ++;
        }

        while(fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

//         if(slow.next != null)
            slow.next = slow.next.next;

        return result.next;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        ListNode head = ListNode.arrayToListNode(array);
        ListNode res = removeNthFromEnd(head, 7);
        String str = ListNode.listNodeToString(res);
        System.out.println(str);
    }
}
