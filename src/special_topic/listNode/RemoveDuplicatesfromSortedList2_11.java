package special_topic.listNode;

/**
 * Time: 2019-07-17
 * Author: snowy
 * Leetcode 82: Remove Duplicates from Sorted List II  删除重复的节点
 * */

public class RemoveDuplicatesfromSortedList2_11 {
    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null)
            return head;

        ListNode result = new ListNode(0);
        ListNode node = result;

        while(head != null) {
            int count = 0;
            int val = head.val;

            while(head != null && head.val == val) {
                count ++;
                head = head.next;
            }

            if(count == 1) {
                node.next = new ListNode(val);
                node = node.next;
            }
        }
        return result.next;
    }
}
