/*
 * @Author: lsd
 * @Date: 2020-02-25 17:58:43
 * @Software: vscode
 * @Description: 
 */
package cn.andios.jianzhi;

public class Test67 {
    public static void main(String[] args) {
        
    }
    public static int cutRope(int target) {
        if(target < 2){
            return 0;
        }
        if(target == 2){
            return 1;
        }
        if(target == 3){
            return 2;
        }
        int[] result = new int[target + 1];
        result[0] = 0;
        result[1] = 1;
        result[2] = 2;
        result[3] = 3;
        for(int i = 4;i <= target;i ++){
            int max = 0;
            for(int j = 1;j <=i / 2;++ j ){
                int res = result[j] * result[i -j];
                max = Math.max(max,res);
                result[i] = max;
            }
        }
        return result[target];
    }
}