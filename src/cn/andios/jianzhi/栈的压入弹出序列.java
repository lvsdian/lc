/*
 * @Author: lsd
 * @Date: 2020-02-22 15:31:27
 * @Software: vscode
 * @Description: 
 *  创建一个辅助栈stack，pushA中的元素一个个进入stack
 *  当stack栈顶元素与popA元素相等时，
 *      stack出弹出栈顶元素，popA要比较的元素位置后移
 * 当pushA中所有元素都进入stack时，如果stack为空，说明都弹出来了，那么返回true,否则返回false
 */
package cn.andios.jianzhi;

import java.util.Stack;

public class 栈的压入弹出序列 {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if(pushA == null || popA == null || pushA.length == 0){
            return false;
        }
        int j = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0;i < pushA.length;i ++){
            stack.push(pushA[i]);
            while(!stack.isEmpty() && stack.peek() ==  popA[j]){
                j ++;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}