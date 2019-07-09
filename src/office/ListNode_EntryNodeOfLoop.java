package office;

/**
 * Time: 2019-04-12
 * Author: snowy
 * Link: https://www.nowcoder.com/practice/253d2c59ec3e4bc68da16833f79a38e4?tpId=13&tqId=11208&tPage=3&rp=4&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * 链表中环的入口结点
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 * */

public class ListNode_EntryNodeOfLoop {
    public static ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null || pHead.next == null)
            return null;

        ListNode slow = pHead;
        ListNode fast = pHead;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                fast = pHead;
                while(fast != slow) {
                    slow = slow.next;
                    fast = fast.next;
                }
                if(fast == slow)
                    return fast;
            }
        }
        return null;
    }

    public static void main(String[] args) {

    }
}
