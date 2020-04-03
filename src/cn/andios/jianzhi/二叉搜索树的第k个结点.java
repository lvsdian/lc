/*
 * @Author: lsd
 * @Date: 2020-02-25 12:17:01
 * @Software: vscode
 * @Description: 
 * 
 *      中序遍历
 */
package cn.andios.jianzhi;

import java.util.*;

public class 二叉搜索树的第k个结点 {
    TreeNode KthNode(TreeNode pRoot, int k)
    {
        if(pRoot == null || k <= 0){
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = pRoot;
        List<TreeNode> list = new ArrayList<>();
        while(cur != null || !stack.isEmpty()){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            list.add(cur);
            cur = cur.right;
        } 
        if(k > list.size()){
            return null;
        }
        return list.get(k - 1);
    }
}