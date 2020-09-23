/*
 * @Author: lsd
 * @Date: 2020-01-14 20:20:06
 * @Description: 
 *      注意：
 *          1.手动导包
 *          2.也可以使用Collections.reverse()方法反转
 *          3.
 *              对于Stack，pop检索并删除；peek检索不删除；push入栈
 *              对于PriorityQueue，poll检索并删除；peek检索不删除；offer与add一模一样都是入队
 * @Software: vscode
 */
package cn.andios.jianzhi;

import java.util.ArrayList;
import java.util.Stack;
public class 从尾到头打印链表 {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<Integer> stack = new Stack();
        ArrayList<Integer> list = new ArrayList();
        while(listNode != null){
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        while(!stack.isEmpty()){
            list.add(stack.pop());
        }
        return list;
    }
}
class ListNode {
    int val;
    ListNode next = null;
    
    ListNode(int val) {
        this.val = val;
    }
}