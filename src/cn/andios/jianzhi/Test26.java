/*
 * @Author: lsd
 * @Date: 2020-02-22 21:54:06
 * @Software: vscode
 * @Description: 
 */
package cn.andios.jianzhi;

import java.util.Stack;

public class Test26 {
    /**
     * 方法一，非递归
     */
    public TreeNode Convert1(TreeNode pRootOfTree) {
        if(pRootOfTree == null){
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = pRootOfTree;
        TreeNode pre = null;
        boolean isFirst = true;
        while(p != null || !stack.isEmpty()){
            while(p != null){
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            if(isFirst){
                pRootOfTree = p;
                pre = pRootOfTree;
                isFirst = false;
            }else{
                pre.right = p;
                p.left = pre;
                pre = p;
            }
            p = p.right;
        }
        return pRootOfTree;
    }

    /**
     * 方法二，递归
     * left指向前指针，right为后指针
     */
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null){
            return null;
        }
        TreeNode left = Convert(pRootOfTree.left);
        TreeNode p = left;
        while(p != null && p.right != null){
            p = p.right;
        }
        if(left != null){
            p.right = pRootOfTree;
            pRootOfTree.left = p;
        }
        TreeNode right = Convert(pRootOfTree.right);
        if(right != null){
            pRootOfTree.right = right;
            right.left = pRootOfTree;
        }
        return  left !=null ? left : pRootOfTree;
    }
}