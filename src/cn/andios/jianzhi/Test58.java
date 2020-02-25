/*
 * @Author: lsd
 * @Date: 2020-02-24 23:18:37
 * @Software: vscode
 * @Description: 
 */
package cn.andios.jianzhi;

public class Test59 {
    boolean isSymmetrical(TreeNode pRoot)
    {
        return isMirror(pRoot,pRoot);
    }
    public boolean isMirror(TreeNode node1,TreeNode node2){
        //都为null
        if(node1 == null && node2 == null){
            return true;
        }
        //都不为null
        if(node1 != null && node2 != null){
            if(node1.val != node2.val){
                return false;
            }
            return isMirror(node1.left, node2.right) && isMirror(node1.right, node2.left);
        }
        //一个为null，一个不为null
        return false;
    }
}