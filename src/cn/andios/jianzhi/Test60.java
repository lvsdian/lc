/*
 * @Author: lsd
 * @Date: 2020-02-24 23:33:18
 * @Software: vscode
 * @Description: 
 *  之字形打印二叉树，其实就是层次遍历，加个isReverse判断
 */
package cn.andios.jianzhi;

import java.util.*;

public class Test60 {
    public ArrayList<ArrayList<Integer> > Print1(TreeNode pRoot) {
        ArrayList<ArrayList<Integer> > list = new  ArrayList<>();
        if(pRoot == null){
            return list;
        }
        Queue<TreeNode> linkedList = new LinkedList<>();
        linkedList.add(pRoot);
        boolean isReverse = false;
        while(!linkedList.isEmpty()){
            int count = linkedList.size();
            ArrayList <Integer> listTmp = new ArrayList<>();
            for(int i = 0;i < count;i ++){
                TreeNode node = linkedList.poll();
                if(!isReverse){
                    listTmp.add(node.val);
                }else{
                    listTmp.add(0,node.val);
                }
                if(node.left != null){
                    linkedList.add(node.left);
                }
                if(node.right != null){
                    linkedList.add(node.right);
                }
            }
            if(listTmp.size() > 0){
                list.add(listTmp);
            }
            
            isReverse = !isReverse;
        }
        return list;
    }

  
}