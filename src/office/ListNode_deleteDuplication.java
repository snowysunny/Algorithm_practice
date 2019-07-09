package office;

/**
 * Time: 2019-04-19
 * Author: snowy
 * Link: https://www.nowcoder.com/practice/fc533c45b73a41b0b44ccba763f866ef?tpId=13&tqId=11209&tPage=3&rp=4&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * 删除链表中重复的结点
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 * */

public class ListNode_deleteDuplication {
    public static ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null)
            return null;

        ListNode res = new ListNode(0);
        ListNode pre = res;
        pre.next = pHead;
        boolean flag = false;
        while (pHead != null) {
            ListNode q = pHead.next;
            if (q == null) break;
            if (q.val == pHead.val) {
                while (q != null && q.val == pHead.val) {
                    q = q.next;
                }
                pre.next = q;
                pHead = q;
            } else {
                if (!flag) {
                    res.next = pHead;
                    flag = true;
                }
                pre = pHead;
                pHead = q;
            }
        }
        return res.next;

//
//        ListNode cur = new ListNode(0);
//
//        cur.next = pHead;
//
//        ListNode res = cur;
//
//        ListNode temp=pHead;
//
//        boolean flag = false;
//
//        while(temp.next != null) {
//            temp = temp.next;
//
//            if(cur.val == temp.val) {
//                flag = true;
//            } else if(flag) {
//                flag = false;
//                cur = temp;
//            } else {
//                cur.next = temp.next;
//            }
//        }
//
//        if(flag)
//            cur = null;
//
//        return res.next;

    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 3, 4, 4, 5};
        ListNode pHead = ListNode.arrayToListNode(array);

        ListNode res = deleteDuplication(pHead);

        String strres = ListNode.listNodeToString(res);
        System.out.println(strres);
    }
}

