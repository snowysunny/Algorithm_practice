package special_topic.listNode;

/**
 * Time: 2019-07-17
 * Author: snowy
 * 复杂链表的复制
 * 这道题的关键在于，复制的时候将原链表：1->2->3->4->5->null  复制为 1->1->2->2->3->3->4->4->5->5->null
 * */
class RandomListNode {
    int label;
    RandomListNode next;
    RandomListNode random;

    RandomListNode(){}
    RandomListNode(int label) {
        this.label = label;
    }
}

public class RandomListNodeClone_11 {
    public RandomListNode Clone(RandomListNode pHead)
    {
        if(pHead == null)
            return null;

        // 链表的克隆
        RandomListNode currentNode = pHead;
        while(currentNode != null) {
            RandomListNode cloneNode = new RandomListNode(currentNode.label);
            cloneNode.next = currentNode.next;

            currentNode.next = cloneNode;

            currentNode = cloneNode.next;
        }

        // 复制老结点的随机指针给新结点
        currentNode = pHead;
        while(currentNode != null) {
            if(currentNode.random != null)
                currentNode.next.random = currentNode.random.next;
            currentNode = currentNode.next.next;
        }

        //3. 拆分链表，将链表拆分为元链表和复制后的链表
        currentNode = pHead;
        RandomListNode pCloneHead = pHead.next;
        while(currentNode != null) {
            RandomListNode cloneNode = currentNode.next;
            currentNode.next = cloneNode.next;
            cloneNode.next = cloneNode.next==null ? null:cloneNode.next.next;
            currentNode = currentNode.next;
        }

        return pCloneHead;
    }
}
