package cn.andios;

import javax.sound.sampled.ReverbType;

/**
 * 
 * @author LSD
 *
 * @datetime 2019年12月21日下午9:09:01
 *
 */
public class Test206 {
	
	
    public static ListNode reverseList(ListNode head) {
        if(head== null) {
        	return null;
        }
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = cur.next;
        while(cur != null) {
        	cur.next = pre;
        	
        	pre = cur;
        	cur = next;
        	next = cur.next;
        	
        }
        return pre;
    }
    
    public static void main(String []args) {
    	for (int i = 0; i < 5; i++) {
    		ListNode listNode = new ListNode(i);
    		listNode.next = listNode;
		}
    
    	ListNode reverseList = reverseList(listNode);
    	while(reverseList.next != null) {
    		System.out.println(reverseList.next.val);
    	}
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}