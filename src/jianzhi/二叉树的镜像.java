/*
 * @Author: lsd
 * @Date: 2020-02-21 23:44:49
 * @Software: vscode
 * @Description: 
 */
package cn.andios.jianzhi;

public class 二叉树的镜像 {
    public void Mirror1(TreeNode root) {
        if(root == null ){
            return ;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        Mirror1(root.left);
        Mirror1(root.right);
    }
}
