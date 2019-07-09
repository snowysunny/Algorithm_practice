package office;

/**
 * Time: 2019-04-10
 * Author: snowy
 * Link: https://www.nowcoder.com/practice/6ab1d9a29e88450685099d45c9e31e46?tpId=13&tqId=11189&tPage=2&rp=2&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * 两个链表的第一个公共结点
 * 输入两个链表，找出它们的第一个公共结点。
 * */

public class ListNode_FindFirstCommonNode {

    /**
     * 先让长序列向前移动几个单位，使其剩余与短序列长度相同
     * */

    public static ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        int length1 = getListNodeLength(pHead1);
        int length2 = getListNodeLength(pHead2);

        if (length1 >= length2) {
            for(int i = 0; i < length1 - length2; i ++)
                pHead1 = pHead1.next;
        } else {
            for(int i = 0; i < length2 - length1; i ++)
                pHead2 = pHead2.next;
        }

        while(pHead1 != null && pHead2 != null) {
            if(pHead1.val == pHead2.val)
                return pHead1;
            pHead1 = pHead1.next;
            pHead2 = pHead2.next;
        }

        return null;
    }

    public static int getListNodeLength(ListNode listnode) {
        int length = 0;
        while(listnode != null) {
            length ++;
            listnode = listnode.next;
        }

        return length;
    }

    public static void main(String[] args) {
        int []headNode1 = {1, 2, 3, 6, 7, 8};
        int []headNode2 = {4, 5, 6, 7, 8};
        ListNode pHead1 = ListNode.arrayToListNode(headNode1);
        ListNode pHead2 = ListNode.arrayToListNode(headNode2);

        ListNode res = FindFirstCommonNode(pHead1, pHead2);

        System.out.println(res.val);
    }
}
