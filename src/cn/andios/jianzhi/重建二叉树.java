/*
 * @Author: lsd
 * @Date: 2020-02-14 13:04:30
 * @Software: vscode
 * @Description: 
 *      前：{1,2,4,7,3,5,6,8}
 *      中：{4,7,2,1,5,3,8,6}
 *  Arrays.copyOfRange：左闭右开
 */
package cn.andios.jianzhi;

import java.util.Arrays;

public class 重建二叉树 {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if(pre.length == 0 || in.length == 0){
            return null;
        }
        TreeNode root = new TreeNode(pre[0]);
        for (int i = 0; i < in.length; i++) {
            if(in[i] == pre[0]){
                root.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, i + 1), Arrays.copyOfRange(in, 0, i));
                root.right = reConstructBinaryTree(Arrays.copyOfRange(pre, i + 1, pre.length), Arrays.copyOfRange(in, i + 1, in.length));
                break;
            }
        }
        return root;
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}