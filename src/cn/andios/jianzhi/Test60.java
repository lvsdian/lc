/*
 * @Author: lsd
 * @Date: 2020-02-24 23:51:07
 * @Software: vscode
 * @Description: 
 */
package cn.andios.jianzhi;
import java.util.*;
public class Test60 {
    ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer> > list = new ArrayList<>();
        if(pRoot == null){
            return list;
        }
        Queue<TreeNode> linkedList = new LinkedList<>();
        linkedList.add(pRoot);
        while(!linkedList.isEmpty()){
            int count = linkedList.size();
            ArrayList<Integer> listTmp = new ArrayList<>();
            while(count >0){
                TreeNode node = linkedList.poll();
                listTmp.add(node.val);
                if(node.left != null){
                    linkedList.add(node.left);
                }
                if(node.right != null){
                    linkedList.add(node.right);
                }
                count --;
            }
            list.add(listTmp);
        }
        return list;
    }
}