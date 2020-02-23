/*
 * @Author: lsd
 * @Date: 2020-02-22 17:14:01
 * @Software: vscode
 * @Description: 
 */
package cn.andios.jianzhi;

import java.util.ArrayList;
import java.util.Stack;

public class Test24 {
    /**
     * 方法一
     */
    public ArrayList<ArrayList<Integer>> FindPath1(TreeNode root,int target) {
        ArrayList<ArrayList<Integer>> listAll = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        if(root == null){
            return listAll;
        }
        helper1(listAll,list,root,target);
        return listAll;
    }
    private void helper1(ArrayList<ArrayList<Integer>> listAll,ArrayList<Integer> list,TreeNode root,int target){
        if(root == null){
            return;
        }
        list.add(root.val);
        target -= root.val;
        if(target ==0 && root.left == null && root.right == null){
            //如果不new,添加的是引用，后序操作会修改它
            listAll.add(new ArrayList(list));
        }
        helper1(listAll,list,root.left,target);
        helper1(listAll,list,root.right,target);
        //到叶子结点后要回退到父节点
        list.remove(list.size() - 1);
    }

    /**
     * 方法二
     * 当前序遍历来做
     */
    public ArrayList<ArrayList<Integer>> FindPath2(TreeNode root,int target) {
        ArrayList<ArrayList<Integer>> listAll = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        if(root == null){
            return listAll;
        }
        int sum = 0;
        helper2(listAll,stack,sum,root,target);
        return listAll;
    }
    private void helper2(ArrayList<ArrayList<Integer>> listAll,Stack<Integer> stack,int sum,TreeNode root,int target){
        if(root == null){
            return;
        }
        stack.push(root.val);
        sum +=  root.val;
        if(root.left == null && root.right == null && sum == target){
            ArrayList<Integer> list = new ArrayList<>();
            list.addAll(stack);
            listAll.add(list);
        }
        helper2(listAll,stack,sum,root.left,target);
        helper2(listAll,stack,sum,root.right,target);
        stack.pop();
    }
}