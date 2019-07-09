package office;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Time: 2019-03-19
 * Author: snowy
 * Link: https://www.nowcoder.com/practice/abc3fe2ce8e146608e868a70efebf62e?tpId=13&tqId=11154&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * 从尾到头打印链表
 * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 * */

public class ListNodePrint {

    public ArrayList<Integer> printListFromTailToHead(ListNode listnode) {
        ArrayList<Integer> res = new ArrayList<>();

        if(listnode == null)
            return res;

        while( listnode != null ) {
            res.add(0, listnode.val);
            listnode = listnode.next;
        }

        return res;
    }

    public static void main(String[] args) {
        ListNodePrint lnp = new ListNodePrint();
        int []nodeValues = {1, 3, 5, 7, 8};
        ListNode testArray = ListNode.arrayToListNode(nodeValues);
        ArrayList<Integer> res = lnp.printListFromTailToHead(testArray);
        System.out.println(Arrays.asList(res));
    }
}
