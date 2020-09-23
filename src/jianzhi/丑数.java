/*
 * @Author: lsd
 * @Date: 2020-02-23 16:56:44
 * @Software: vscode
 * @Description: 
 */
package cn.andios.jianzhi;

public class 丑数 {

    public static void main(String[] args) {
        new 丑数().GetUglyNumber_Solution(10);
    }

    
    public int GetUglyNumber_Solution(int index) {
        if(index <= 0){
            return 0;
        }
        int p2 = 0,p3 = 0,  p5 = 0;
        int [] result = new int[index];
        result[0] = 1;
        for(int i = 1;i < index;i ++){
            result[i] = Math.min(result[p2]*2,Math.min(result[p3]*3,result[p5]*5));
            if(result[i] == result[p2]*2)p2 ++;
            if(result[i] == result[p3]*3)p3 ++;
            if(result[i] == result[p5]*5)p5 ++;
        }
        return result[index -1];
    }
    
}