/*
 * @Author: lsd
 * @Date: 2020-02-21 21:47:53
 * @Software: vscode
 * @Description: 
 */
package cn.andios.jianzhi;

public class 合并两个排序链表 {
    public ListNode Merge(ListNode list1,ListNode list2) {
        ListNode head = new ListNode(Integer.MIN_VALUE);
        ListNode header = head;
        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                header.next = list1;
                list1 = list1.next;
            }else{
                header.next = list2;
                list2 = list2.next;
            }
            header = header.next;
        }
        while(list1 != null){
            header.next = list1;
            list1 = list1.next;
            header = header.next;
        }
        while(list2 != null){
            header.next = list2;
            list2 = list2.next;
            header = header.next;
        }
        return head.next;
        
    }
}