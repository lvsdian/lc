/*
 * @Author: lsd
 * @Date: 2020-02-22 15:17:07
 * @Software: vscode
 * @Description: 
 * 
 *  两个栈，一个用于存所有元素，一个用于存当前栈内的最小元素
 */
package cn.andios.jianzhi;

import java.util.Stack;

public class 包含min函数的栈 {
    private static Stack<Integer> dataStack = new Stack<>();
    private static Stack<Integer> minStack = new Stack<>();
    
    public void push(int node) {
        dataStack.push(node);
        if(!minStack.isEmpty() && minStack.peek() < node){
            minStack.push(minStack.peek());
        }else{
            minStack.push(node);
        }
    } 
    
    public void pop() {
        if(!dataStack.isEmpty()){
            dataStack.pop();
            minStack.pop();
        }
    }
    
    public int top() {
        if(!dataStack.isEmpty()){
            return dataStack.peek();
        }
        throw new IllegalStateException("stack is empty");
    }
    
    public int min() {
        if(!dataStack.isEmpty()){
            return minStack.peek();
        }
        throw new IllegalStateException("stack is empty");
                  
    }    
}