package special_topic.listNode;

/**
 * Time: 2019-07-16
 * Author: snowy
 * 删除链表中的一个结点
 * */

public class DeleteOneNode_1 {
    public static ListNode deleteNode(ListNode head, ListNode node) {
        // 如果输入参数为null或者head为null，则直接返回head
        if(head == null || node == null)
            return head;

        // 如果删除的是头结点，直接返回头结点的下一个结点
        if(head == node)
            return head.next;

        // 如果要删除的是尾结点，那么只能遍历啦
        if(node.next == null) {
            ListNode cur = head;
            while(cur.next != node)
                cur = cur.next;
            cur.next = null;
        } else {
            // 将当前结点的值置为下一个结点的值，删除下一个结点
            node.val = node.next.val;
            node.next = node.next.next;
        }

        return head;
    }

    public static void main(String[] args) {

    }
}
