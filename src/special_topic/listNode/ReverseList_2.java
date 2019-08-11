package special_topic.listNode;

import java.util.List;

public class ReverseList_2 {

    public static ListNode reverseList(ListNode head) {
        if(head == null)
            return head;

        ListNode node = new ListNode(0);

        while(head != null) {
            ListNode temp = head.next;
            head.next = node.next;
            node.next = head;
            head = temp;
        }
        return node.next;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6};
        ListNode head = ListNode.arrayToListNode(array);
        List<Integer> res = ListNode.listNodeToList(reverseList(head));
        System.out.println(res);
    }
}
