/*
 * @Author: lsd
 * @Date: 2020-02-21 18:33:32
 * @Software: vscode
 * @Description: 
 *      target = 1，1种
 *      target = 2，2种
 *      target = 3，第1块，横着 f(1)
 *                  第1块，竖着 f(2)
 *      target = 4，第1块，横着 f(2)
 *                  第1块，竖着 f(3)
 *      
 *      因此，f(n) = f(n - 1) + f(n - 2)
 * 
 */
package cn.andios.jianzhi;

public class 矩形覆盖 {
    public int RectCover(int target) {
        if(target <= 2 ){
           return target;
       }
       int[] sum = new int [target + 1];
       sum[1] = 1;
       sum[2] = 2;
       for(int i = 3;i <= target;i ++ ){
           sum[i] = sum[i - 1] + sum[i - 2];
       }
       return sum[target];
   }
}