package leetcode.listnode.com;

import java.util.Arrays;

/**
 * Time:2019-05-02
 * Author: snowy
 * Leetcode 23: mergeKLists
 * 思路： 使用分治法，首先编写一个二路归并
 * */

public class MergeKLists {

    public static ListNode mergeLists(ListNode[] lists) {

        if(lists.length < 1 || lists == null)
            return null;

        if(lists.length == 1)
            return lists[0];

        // 将原数组分成两半
        ListNode[] left = Arrays.copyOfRange(lists, 0, lists.length / 2);
        ListNode[] right = Arrays.copyOfRange(lists, lists.length / 2, lists.length);

        return merge(mergeLists(left), mergeLists(right));

    }

//    二路归并
    public static ListNode merge(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;

        ListNode head = new ListNode(0);
        ListNode help = head;
        while(list1 != null && list2 != null) {
            if(list1.val <= list2.val) {
                help.next = list1;
                list1 = list1.next;
            } else {
                help.next = list2;
                list2 = list2.next;
            }
            help = help.next;
        }
        if(list1 != null)
            help.next = list1;
        if(list2 != null)
            help.next = list2;
        return head.next;
    }

    public static void main(String[] args) {
        int[] node1 = {1, 4, 5};
        int[] node2 = {1, 3, 4};
        int[] node3 = {2, 6};
        ListNode list1 = ListNode.arrayToListNode(node1);
        ListNode list2 = ListNode.arrayToListNode(node2);
        ListNode list3 = ListNode.arrayToListNode(node3);
        ListNode[] lists = {list1, list2, list3};
//        ListNode res = merge(list1, list2);
//        String result = ListNode.listNodeToSting(res);
        ListNode res = mergeLists(lists);
        String result = ListNode.listNodeToString(res);
        System.out.println(result);

    }

}
