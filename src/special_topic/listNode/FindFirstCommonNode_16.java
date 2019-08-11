package special_topic.listNode;

/**
 * Time：2019-07-17
 * Author： snowy
 * 寻找两个相交列表的第一个相交点
 * 三种最优方法 ：
 *               方法一 先找出2个链表的长度，然后让长的先走两个链表的长度差，然后再一起走，直到找到第一个公共结点。
 *               方法二 由于2个链表都没有环，我们可以把第二个链表接在第一个链表后面，这样就把问题转化为求环的入口节点问题。
 *               方法三 两个指针p1和p2分别指向链表A和链表B，它们同时向前走，当走到尾节点时，转向另一个链表，比如p1走到链表 A 的尾节点时，下一步就走到链表B，p2走到链表 B 的尾节点时，下一步就走到链表 A，当p1==p2 时，就是链表的相交点
 *
 * */

public class FindFirstCommonNode_16 {
    // 方法一
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if(pHead1 == null || pHead2 == null)
            return null;
        int length1 = 0, length2 = 0;

        ListNode cur1 = pHead1;
        ListNode cur2 = pHead2;

        while(cur1 != null) {
            cur1 = cur1.next;
            length1 ++;
        }
        while(cur2 != null) {
            cur2 = cur2.next;
            length2 ++;
        }

        cur1 = pHead1;
        cur2 = pHead2;

        if(length1 <= length2) {
            for(int i = 0; i < length2 - length1; i ++)
                cur2 = cur2.next;
        } else {
            for(int i = 0; i < length1 - length2; i ++)
                cur1 = cur1.next;
        }

        while(cur1 != null && cur2 != null && cur1 != cur2) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }

        return cur1;

    }
}
