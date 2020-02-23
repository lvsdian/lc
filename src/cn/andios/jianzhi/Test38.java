/*
 * @Author: lsd
 * @Date: 2020-02-23 22:39:11
 * @Software: vscode
 * @Description:
 */
package cn.andios.jianzhi;

import java.util.LinkedList;
import java.util.Queue;

public class Test38 {

    //递归 or 层次遍历
    public int TreeDepth1(TreeNode root) {
        if(root == null){
            return 0;
        }  
        int depth = 0;
        int l = TreeDepth1(root.left);
        int r = TreeDepth1(root.right);
        depth = Math.max(l,r) + 1;
        return depth;
    }

    public int TreeDepth2(TreeNode root){
        if(root == null){
            return 0;
        } 
        int high = 0;
        Queue<TreeNode> linkedList = new LinkedList<>();
        linkedList.add(root);
        while(!linkedList.isEmpty()){
            high ++;
            TreeNode node = linkedList.poll();
            if(node.left != null){
                linkedList.add(node.left);
            }
            if(node.right != null){
                linkedList.add(node.right);
            }
        }
        return high;
    }

    //层次遍历
    public int TreeDepth(TreeNode root) {
        if(root == null){
           return 0;
       } 
       int high = 0;
       Queue<TreeNode> linkedList = new LinkedList<>();
       linkedList.add(root);
       int size = 0;
       TreeNode node = null;
       while(!linkedList.isEmpty()){
           size = linkedList.size();
           while(size != 0){
               node = linkedList.poll();
               if(node.left != null){
                   linkedList.add(node.left);
               }
               if(node.right != null){
                   linkedList.add(node.right);
               }
               size --;
           }
           high ++;
       }
       return high;
   }
}