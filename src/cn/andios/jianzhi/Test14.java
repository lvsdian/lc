/*
 * @Author: lsd
 * @Date: 2020-02-21 20:59:49
 * @Software: vscode
 * @Description: 
 *      慢指针指向head，快指针移到k个节点位置 （坑：k可能大于链表长度，注意判断）
 */
package cn.andios.jianzhi;

public class Test14 {
    public ListNode FindKthToTail(ListNode head,int k) {
        if(head == null || k == 0){
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        for(int i = 0;i < k;i ++){
            //k大于链表长度就返回null
            if(fast == null){
                return null;
            }
            fast = fast.next;
        }
        while(fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}