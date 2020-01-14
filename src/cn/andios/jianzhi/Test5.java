/*
 * @Author: lsd
 * @Date: 2020-01-14 21:01:02
 * @Description: 
 *      case:  push1 push2 push3 pop pop push4 pop  push5 pop
 *             result：12345
 * @Software: vscode
 */
package cn.andios.jianzhi;

import java.util.Stack;

public class Test5 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    
    public void push(int node) {
        stack1.push(node);
    }
    
    public int pop() {
        while(!stack1.isEmpty()){
            int temp = stack1.pop();
            stack2.push(temp);
        }
        int x = stack2.pop();
        if(!stack2.isEmpty()){
            int tmp = stack2.pop();
            stack1.push(tmp);
        }
        return x;
    }
}