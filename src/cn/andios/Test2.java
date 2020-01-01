package cn.andios;
/**
 * 
 * @author LSD
 *
 * @datetime 2020年1月1日下午8:06:54
 *
 */
public class Test2 {
    public static ListNode6 addTwoNumbers(ListNode6 l1, ListNode6  l2) {
        long num1 = 0 ,num2 = 0,sum = 0;
        
        ListNode6 head1 = new ListNode6(Integer.MAX_VALUE);
        ListNode6 head2 = new ListNode6(Integer.MAX_VALUE);
        
        ListNode6 head = new ListNode6(Integer.MAX_VALUE);
        ListNode6 tail = head;
        
        ListNode6 newNode;
        //将l1反过来，head1才是l1真正表示的数
        while(l1 != null) {
        	newNode = l1;
        	l1 = l1.next;
        	newNode.next = head1.next;
        	head1.next = newNode;
        	
        }
        //将l2反过来，head2才是l2真正表示的数
        while(l2 != null) {
        	newNode = l2;
        	l2 = l2.next;
        	newNode.next = head2.next;
        	head2.next = newNode;
        	
        }
        //将head1表示的数变为long型
        head1 = head1.next;
        while(head1 != null) {
        	num1 = num1*10;
        	num1 += head1.val;
        	head1 = head1.next;
        }
        //将head2表示的数变为long型
        head2 = head2.next;
        while(head2 != null) {
        	num2 = num2*10;
        	num2 += head2.val;
        	head2 = head2.next;
        }
        
        sum = num1 + num2;
        
        if(sum  == 0) {
        	head.next = new ListNode6(0);
        	return head.next;
        }
        while(sum != 0) {
        	newNode = new ListNode6((int)sum % 10);
        	tail.next = newNode;
        	tail = tail.next;
        	
        	sum /= 10;
        }
        
//        while(head1 != null) {
//        	System.out.print(head1.val+"\t");
//        	head1 = head1.next;
//        }
//        System.out.println();
//        while(head2 != null) {
//        	System.out.print(head2.val+"\t");
//        	head2 = head2.next;
//        }
        
//        System.out.println(num1);
//        System.out.println(num2);
        
//        head = head.next;
//        while(head != null) {
//        	System.out.print(head.val+"\t");
//        	head = head.next;
//        }
        return head.next;
    }
	public static void main(String[] args) {
		//构建两个链表
		ListNode6 head1 = new ListNode6(9);
		ListNode6 tail1 = head1;
		
		ListNode6 head2 = new ListNode6(5);
		ListNode6 tail2 = head2;
		
		ListNode6 newNode;
		
		int[] arr = new int[] {1,9,9,9,9,9,9,9,9,9};
		
//		for (int i = 0; i < arr.length-2; i++) {
//			newNode = new ListNode6(arr[i]);
//			tail1.next = newNode;
//			tail1 = tail1.next;		
//		}
		for (int i = 0; i < arr.length; i++) {
			newNode = new ListNode6(arr[i]);
			tail2.next = newNode;
			tail2 = tail2.next;		
		}
		//002  0  [9]
//		while(head1 != null) {
//			System.out.print(head1.val+"\t");
//			head1 = head1.next;
//		}
		//653  0  [1,9,9,9,9,9,9,9,9,9]
//		System.out.println();
//		while(head2 != null) {
//			System.out.print(head2.val+"\t");
//			head2 = head2.next;
//		}
		
		ListNode6 addTwoNumbers = addTwoNumbers(head1, head2);
		while(addTwoNumbers != null) {
			System.out.print(addTwoNumbers.val+"\t");
			addTwoNumbers = addTwoNumbers.next;
		}
	}
}
/**
 * 节点类
 */
class ListNode6 {    
	int val;
    ListNode6 next;
    ListNode6(int x) { val = x; }
}