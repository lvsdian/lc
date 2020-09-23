/*
 * @Author: lsd
 * @Date: 2020-02-23 23:30:05
 * @Software: vscode
 * @Description: 
 *  判断平衡二叉树，只遍历一次
 */
package cn.andios.jianzhi;

public class 平衡二叉树 {
    public boolean IsBalanced_Solution(TreeNode root) {
        if(root == null){
            return true;
        }
        return getDepth(root) != -1;
    }
    public  int getDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        int lDepth = getDepth(root.left);
        if(lDepth == -1){
            return -1;
        }
        int rDepth = getDepth(root.right);
        if(rDepth == -1){
            return -1;
        }
        if(Math.abs(lDepth - rDepth) > 1)
            return -1;
        return Math.max(lDepth, rDepth) + 1;
    } 
}