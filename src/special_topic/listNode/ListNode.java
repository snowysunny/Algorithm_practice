package special_topic.listNode;

import java.util.ArrayList;
import java.util.List;

public class ListNode {
    int val;
    ListNode next;
    public ListNode() {}
    public ListNode(int val) {
        this.val = val;
    }

    public static ListNode arrayToListNode(int[] array) {
        if(array == null || array.length < 1)
            return null;

        ListNode head = new ListNode(0);
        ListNode node = head;

        for(int i = 0; i < array.length; i ++) {
            node.next = new ListNode(array[i]);
            node = node.next;
        }

        return head.next;
    }

    public static List<Integer> listNodeToList(ListNode node) {
        List<Integer> list = new ArrayList<>();
        while(node != null) {
            list.add(node.val);
            node = node.next;
        }

        return list;
    }

    public static void main(String[] args) {
        int[] array = {1, 3, 5, 7, 8, 3, 2, 6, 4, 9};
        ListNode listnode = new ListNode();
        ListNode node = listnode.arrayToListNode(array);
        List<Integer> list = listnode.listNodeToList(node);
        System.out.println(list);
    }

}
