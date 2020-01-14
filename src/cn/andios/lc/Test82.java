/*
 * @Author: lsd
 * @Date: 2020-01-14 21:09:09
 * @Description: 
 * @Software: vscode
 */
package cn.andios.lc;

public class Test82 {
    public static void main(String[] args) {
        int [] arr = new int []{1,2,3,3,4,4,5};
        ListNode9 head = new ListNode9(Integer.MAX_VALUE);
        ListNode9 tail = head;
        ListNode9 newNode = null; 
        for (int i = 0; i < arr.length; i++) {
            newNode = new ListNode9(arr[i]);
            tail.next = newNode;
            tail = tail.next;
        }
        // while(head != null){
        //     System.out.print(head.val + "\t");
        //     head = head.next;
        // }

        ListNode9 listNode = deleteDuplicates(head.next);
        while(listNode != null){
            System.out.print(listNode.val + "\t");
            listNode = listNode.next;
        }
    }
    public static ListNode9 deleteDuplicates(ListNode9 head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode9 header1 = new ListNode9(Integer.MAX_VALUE);
        
        header1.next = head;
        ListNode9 header2 = header1;

        ListNode9 nextNode = header1.next.next;
        while()


        return null;
    }
}

 
class ListNode9 {
    int val;
    ListNode9 next;
    ListNode9(int x) { val = x; }
}
 