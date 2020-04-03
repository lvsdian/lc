/*
 * @Author: lsd
 * @Date: 2020-01-15 23:30:11
 * @Description: 
 * @Software: vscode
 */
package cn.andios.jianzhi;

public class 斐波那契数列 {
    public int Fibonacci1(int n) {
        if(n <= 0){
            return 0;
        }else if(n == 1){
            return 1;
        }else{
            return Fibonacci1(n - 1)+Fibonacci1(n-2);
        }
    }
    //优化一：时间优化
    //用数组存储前面算的值,不用计算大量相同的数据
    public int Fibonacci2(int n) {
        int [] arr = new int [40];
        arr[0] = 0;
        arr[1] =1;
        for(int i= 2;i <=n;i ++){
            arr[i] = arr[i-1] +arr[i-2];
        }
        return arr[n];
    }

    //优化二：空间优化
    //只需要存最近的两个组，不需要用数组存所有数
    public int Fibonacci3(int n) {
        if(n <= 0){
            return 0;
        }else if(n == 1){
            return 1;
        }
        int one = 1,two = 0,sum = 0;
        for (int i = 2; i <= n; i++) {
            sum = one + two;
            two = one;
            one = sum;
        }
        return sum;
    }
    //优化三：持续优化
    //只需要存最近的两个组，不需要用数组存所有数
    public int Fibonacci4(int n) {
        if(n <= 0){
            return 0;
        }else if(n == 1){
            return 1;
        }
        int one = 1,sum = 1;
        for (int i = 2; i <= n; i++) {
            sum = sum + one;
            one = sum - one;
        }
        return sum;
    }

}