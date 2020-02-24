/*
 * @Author: lsd
 * @Date: 2020-02-24 19:06:35
 * @Software: vscode
 * @Description: 
 * 
 *  可以画一个表格，左上角->右下角的对角线不参与乘，每一行，对角线左边记为new int[] C，右边记为new int D
 *  
 */
package cn.andios.jianzhi;

public class Test51 {
    public int[] multiply(int[] A) {
        if(A == null || A.length == 0){
            return null;
        }
        int[] C = new int[A.length];
        C[0] = 1;
        for(int i = 1;i < A.length;i ++){
            C[i] = C[i - 1] * A[i - 1];
        }
        
        int[] D = new int[A.length];
        D[D.length - 1] = 1;
        for(int i = D.length - 2;i >=0;i --){
            D[i] = D[i + 1] * A[i + 1];
        }
        int[] result = new int[A.length];
        for(int i = 0;i < result.length;i ++){
            result[i] = C[i] * D[i];
        }
        return result;
    }
}