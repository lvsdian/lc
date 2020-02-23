/*
 * @Author: lsd
 * @Date: 2020-02-22 15:34:42
 * @Software: vscode
 * @Description: 
 *  层次遍历
 */
package cn.andios.jianzhi;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Test22 {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        Queue<TreeNode> linkedList = new LinkedList<>();
        linkedList.add(root);
        while(!linkedList.isEmpty()){
            TreeNode node = linkedList.poll();
            list.add(node.val);
            if(node.left != null){
                linkedList.add(node.left);
            }
            if(node.right != null){
                linkedList.add(node.right);
            }
        }
        return list;
    }
}