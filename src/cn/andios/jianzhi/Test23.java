/*
 * @Author: lsd
 * @Date: 2020-02-22 16:31:13
 * @Software: vscode
 * @Description: 
 *      二叉搜索树，左节点 > 根节点 > 右节点
 *      后序遍历结果：根节点在最后位置，所以数组中根节点之前的元素有一半比它小，有一半比它大，根据这个来判断
 */
package cn.andios.jianzhi;

public class Test23 {
    public static void main(String[] args) {
        boolean is = VerifySquenceOfBST(new int[]{3, 4, 9, 5, 12, 11, 10});
        System.out.println("is：" + is);
    }

    public static boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence == null || sequence.length == 0){
            return false;
        }
        return isSequenceOfBST(sequence,0,sequence.length - 1);
    }
    public static boolean isSequenceOfBST(int [] sequence,int start,int end){
        if(start >= end){
            return true;
        }
        int val = sequence[end];
        int split = start;
        while(sequence[split] < val){
            split ++;
        }
        //[start,split - 1]位置应该比val小，[split,end - 1]位置应该比val大，
        //所以[split,end - 1]中出现比val小的就直接返回false
        for(int i = split;i <end;i ++){
            if(sequence[i] < val){
                return false;
            }
        }
        return isSequenceOfBST(sequence,start,split - 1) && isSequenceOfBST(sequence,split,end - 1);
    }
}