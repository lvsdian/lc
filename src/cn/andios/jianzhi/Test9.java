/*
 * @Author: lsd
 * @Date: 2020-02-21 18:13:11
 * @Software: vscode
 * @Description: 
 *      对于f(n)，如果跳一级台阶为f(n - 1)
 *                如果跳两级台阶为f(n - 2)
 *                如果跳三级台阶为f(n - 3)
 *                      n        f(0)
 *              所以， f(n) = f(n - 1) + f(n - 2) + ... + f(0)
 *              所以， f(n-1)= f(n - 2) + ... + f(0)
*               两式一减
                      f(n) = 2f(n - 1)
 */
package cn.andios.jianzhi;

public class Test9 {
    public int JumpFloorII(int target) {
        if(target < 2){
            return target;
        }
        int[] sum = new int [target + 1];
        sum[1] = 1;
        sum[2] = 2;
        for(int i = 3;i <= target;i ++ ){
            sum[i] = 2 * sum[i - 1];
        }
        return sum[target];
    }
}