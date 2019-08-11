package special_topic.listNode;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * Time: 2019-07-16
 * Author: snowy
 *
 * */

public class reverseBetween_3 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // 为null直接返回
        if(head == null || m >= n)
            return head;

        int count = 1;
        ListNode node = new ListNode(0);
        ListNode help = node;

        // 首先将m之前的复制过来
        while(head != null && count < m) {
            // ListNode next = head.next;
            help.next = head;
            help = help.next;
            head = head.next;
            count ++;
        }

        ListNode mNode = null;
        // 头插法
        while(head != null && count <= n) {
            if(count == m)
                mNode = head;
            ListNode next = head.next;
            head.next = help.next;
            help.next = head;
            head = next;
            count ++;
        }

        mNode.next = head;

        return node.next;
    }

    public static void main(String[] args) {
        Integer[] array = {31, 4, 52, 255};
        Arrays.sort(array, new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                String s1 = o1 + "" + o2;
                String s2 = o2 + "" + o1;
                return s2.compareTo(s1);
            }
        });

        System.out.println(Arrays.toString(array));

    }
}
