package leetcode.listnode.com;

/**
 * Time: 2019-07-03
 * Author: snowy
 * Leetcode 160: Intersection of Two Linked Lists
 * */

public class IntersectionofTwoLinkedLists_160 {

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null)
            return null;

        int lengthA = 0, lengthB = 0;

        ListNode A = headA,  B = headB;
        while(A != null) {
            lengthA ++;
            A = A.next;
        }

        while(B != null) {
            lengthB ++;
            B = B.next;
        }

        while(lengthA > lengthB) {
            headA = headA.next;
            lengthA --;
        }

        while(lengthB > lengthA) {
            headB = headB.next;
            lengthB --;
        }

        while(headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }

        return headA;
    }

    public static void main(String[] args) {

    }
}
