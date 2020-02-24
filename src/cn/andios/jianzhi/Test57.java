/*
 * @Author: lsd
 * @Date: 2020-02-24 22:40:38
 * @Software: vscode
 * @Description: 
 */
package cn.andios.jianzhi;

public class Test57 {
    public ListNode deleteDuplication(ListNode pHead)
    {
       if(pHead == null || pHead.next == null){
            return pHead;
        }
        //虚拟头节点
        ListNode header = new ListNode(Integer.MAX_VALUE);
        
        header.next = pHead;
        //快慢指针
        //慢指针指向虚拟头节点，记录最后返回的链表的节点
        ListNode slow = header;
        //快指针遍历链表
        ListNode fast = header.next;
        //快指针与快指针.next是否重复的标志
        boolean isDump;
        while(fast != null){
            isDump = false;
            //如果重复了，快指针就一直后移
            while(fast.next != null && fast.val == fast.next.val){
                isDump = true;
                fast = fast.next;        
            }
            //一旦没重复，就把快指针节点添加到慢指针中
            if(!isDump){
                slow.next = fast;
                slow = slow.next;
            }
            //快指针后移
            fast = fast.next;
        }
        slow.next = null;
        return header.next;
    }
}