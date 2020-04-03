/*
 * @Author: lsd
 * @Date: 2020-02-24 22:28:05
 * @Software: vscode
 * @Description: 
 * 
 *  环形链表问题
 */
package cn.andios.jianzhi;

public class 链表中环的入口结点 {
    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        if(pHead == null){
            return null;
        }
        ListNode slow = pHead;
        ListNode fast = pHead;
        boolean flag = false;
        while(slow != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                flag = true;
                break;
            }
        }
        if(!flag){
            return null;
        }else{
            //获取环节点数目
            int count = 1;
            fast = fast.next;
            while(fast != slow){
                count ++;
                fast = fast.next;
            }
            fast = slow = pHead;
            for(int i = 0;i < count;i ++){
                fast = fast.next;
            }
            while(fast != slow){
                slow = slow.next;
                fast = fast.next;
            }
            return slow;
        }
    }
}