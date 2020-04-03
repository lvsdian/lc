/*
 * @Author: lsd
 * @Date: 2020-02-21 22:54:06
 * @Software: vscode
 * @Description: 
 *      子树：只要包含了一个结点，就得包含这个结点下的所有节点。
 *      子结构：符合树的一部分节点即可
 */
package cn.andios.jianzhi;

public class 树的子结构 {
    
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if(root1 == null || root2 == null){
            return false;
        }
        return isSubtree(root1,root2) || isSubtree(root1.left,root2) || isSubtree(root1.right,root2);
        
    }
    /**
     * 这个方法中假设root1与root2节点值相同，
     * 如果不同，返回true,
     * 如果相同，遍历它们的子节点，
     *      如果root2先遍历完，那么root2就是子结构
     *      如果root1先遍历完，那么root2就不是子结构
     */
    public boolean isSubtree(TreeNode root1,TreeNode root2){
        if(root2 == null){
            return true;
        }
        if(root1 == null){
            return false;
        }
        if(root1.val != root2.val){
            return false;
        }
        return isSubtree(root1.left,root2.left) && isSubtree(root1.right,root2.right);
    }
}