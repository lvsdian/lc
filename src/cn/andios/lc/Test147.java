/*
 * @Author: lsd
 * @Date: 2020-01-23 22:43:15
 * @Software: vscode
 * @Description: 
 */
package cn.andios.lc;

public class Test147 {
    public static void main(String[] args) {
        ListNode12 head = new ListNode12(Integer.MAX_VALUE);
        ListNode12 newNode = null;
        int [] arr = new int []{4,2,1,3};
        for (int i = arr.length - 1; i >= 0; i--) {
            newNode = new ListNode12(arr[i]);
            newNode.next = head.next;
            head.next = newNode;
        }

        //head = head.next;
        // while(head != null){
        //     System.out.print(head.val+"\t");
        //     head = head.next;
        // }
        ListNode12 list = insertionSortList(head.next);
        while(list != null){
            System.out.print(list.val + "\t");
            list = list.next;
        }
    }

    public static ListNode12 insertionSortList(ListNode12 head) {
        ListNode12 header = new ListNode12(Integer.MAX_VALUE);
        header.next = head;
        while(head != null){

        }
        return null;
    }
}
class ListNode12 {
    int val;
    ListNode12 next;
    ListNode12(int x) {
        val = x;
    }
}
 