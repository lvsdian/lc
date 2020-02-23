/*
 * @Author: lsd
 * @Date: 2020-02-21 18:51:00
 * @Software: vscode
 * @Description: 
 */
package cn.andios.jianzhi;

public class Test12 {

    public static void main(String[] args) {
        double a = new Test12().Power(2.0,2);
        System.out.println(a);
    } 

    public double Power(double base, int exponent) {
        double result = 1.0d;
        if(exponent == 0){
            return result;
        }
        exponent =  exponent > 0 ? exponent : -exponent;
        for (int i = 1; i <= exponent; i++) {
            result *= base;
        }
        return exponent > 0 ? result : 1 / result;
    }
}