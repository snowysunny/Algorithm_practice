package special_topic.listNode;

/**
 * Time: 2019-07-17
 * Author: snowy
 * Leetcode 148: Sort List
 * 链表的快排   和    链表的归并排序
 * */

public class SortList_9 {

    // 链表的快排
    public static ListNode sortList_quick(ListNode head) {
        if(head == null)
            return head;
        quickSort(head, null);
        return head;
    }

    public static void quickSort(ListNode head, ListNode end) {
        if(head != end) {
            ListNode node = partition(head, end);
            quickSort(head, node);
            quickSort(node.next, end);
        }
    }

    public static ListNode partition(ListNode head, ListNode end) {
        ListNode p1 = head;
        ListNode p2 = head.next;
        while(p2 != end) {

            // 说明之前的p2都是大于head的值的，因此p1的下一个的值应该是大于head的值的，交换p1.next.val 和p2.val
            if(p2.val < head.val) {
                p1 = p1.next;
                int temp = p1.val;
                p1.val = p2.val;
                p2.val = temp;
            }

            p2 = p2.next;
        }

        if(p1 != head) {
            int temp = head.val;
            head.val = p1.val;
            p1.val = temp;
        }
        return p1;
    }

    public static ListNode sortList_merge(ListNode head) {
        if(head == null || head.next == null)
            return head;

        ListNode middle = findMiddle(head);
        ListNode right = middle.next;
        middle.next = null;

        return mergeTwoList(sortList_merge(head), sortList_merge(right));
    }

    // 寻找一个列表的中间位置前面的那个位置
    public static ListNode findMiddle(ListNode head) {
        if(head == null || head.next == null)
            return head;

        ListNode slow = head;
        ListNode fast = head.next;

        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    // 合并两个有序列表
    public static ListNode mergeTwoList(ListNode left, ListNode right) {
        if(left == null)
            return right;
        if(right == null)
            return left;

        ListNode head = new ListNode(0);
        ListNode cur = head;

        while(left != null && right != null) {
            if(left.val <= right.val) {
                cur.next = left;
                cur = cur.next;
                left = left.next;
            } else {
                cur.next = right;
                cur = cur.next;
                right = right.next;
            }
        }

        if(left != null)
            cur.next = left;
        if(right != null)
            cur.next = right;

        return head.next;
    }



}
