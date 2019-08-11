package special_topic.listNode;

import java.util.List;

public class RotateList_4 {
    public static ListNode rotateRight(ListNode head, int k) {
        if(head == null || k < 1)
            return head;

        // 快慢指针
        ListNode fast = head;
        ListNode slow = head;
        int count = 1;

        // 快指针先走，同时统计长度
        while(count <= k && fast.next != null) {
            fast = fast.next;
            count ++;
        }
        // 若果k是链表长度的整数倍，那么直接返回就行
        if(k % count == 0)
            return head;
        // 如果k大于了链表长度，那么快指针重新走一遍
        if(count <= k) {
            k = k % count;
            count = 1;
            fast = head;
            while(count <= k) {
                fast = fast.next;
                count ++;
            }
        }
        // 当快指针的下一步为null时，慢指针的下一步就是旋转开始的地方
        while(fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        ListNode node = slow.next;
        slow.next = null;
        fast.next = head;

        return node;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        int k = 2;
        ListNode head = ListNode.arrayToListNode(array);
        ListNode res = rotateRight(head, k);
        List<Integer> list = ListNode.listNodeToList(res);
        System.out.println(list);
    }
}
