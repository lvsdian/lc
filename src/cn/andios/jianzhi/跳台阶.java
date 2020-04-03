/*
 * @Author: lsd
 * @Date: 2020-02-21 18:13:44
 * @Software: vscode
 * @Description: 
 *      对于f(n)，如果跳一级台阶为f(n - 1)
 *                如果跳两级台阶为f(n - 2)
 *              那么，f(n) = f(n - 1) + f(n - 2)
 */
package cn.andios.jianzhi;

public class 跳台阶 {
    public int JumpFloor(int target) {
        if(target == 0){
            return 0;
        }
        int[] sum = new int [target + 1];
        if(target == 1){
            return 1;
        }
        sum[1] = 1;
        if(target == 2){
            return 2;
        }
        sum[2] = 2;
        for(int i = 3;i <= target;i ++ ){
            sum[i] = sum[i - 1] + sum[i - 2];
        }
        return sum[target];
    }
}