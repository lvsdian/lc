/*
 * @Author: lsd
 * @Date: 2020-02-22 18:41:42
 * @Software: vscode
 * @Description: 
 *      3次遍历，第一次，将每个节点复制，比如 A->B->null 就复制为 A->A1->B->B1->null
 *              第二次，复制每个节点的random指针
 *              第三次，将链表一分为二：原链表、复制链表。返回复制链表。
 */
package cn.andios.jianzhi;

public class 复杂链表的复制 {
    public RandomListNode Clone(RandomListNode pHead){
        if(pHead == null){
            return null;
        }
        RandomListNode curNode = pHead;
        //复制每一个节点，比如 A->B->null 就复制为 A->A1->B->B1->null
        while(curNode != null){
            RandomListNode cloneNode = new RandomListNode(curNode.label);
            RandomListNode nextNode = curNode.next;
            cloneNode.next = curNode.next;
            curNode.next = cloneNode;
            curNode = nextNode;
        }
        //复制老节点的随机指针给新节点
        curNode = pHead;
        while(curNode != null){
            curNode.next.random = curNode.random == null ? null : curNode.random.next;
            curNode = curNode.next.next;
        }
        //拆分链表,分成原链表和复制后的链表
        curNode = pHead;
        RandomListNode pCloneHead = pHead.next;
        while(curNode != null){
            RandomListNode cloneNode = curNode.next;
            curNode.next = cloneNode.next;
            cloneNode.next = cloneNode.next == null ? null : cloneNode.next.next;
            curNode = curNode.next;
        }
        return pCloneHead;
    }
}

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}