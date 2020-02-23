/*
 * @Author: lsd
 * @Date: 2020-02-21 21:37:10
 * @Software: vscode
 * @Description: 反正链表
 */
package cn.andios.jianzhi;

public class Test15 {
    public ListNode ReverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode pre = null;
        ListNode cur = head;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}