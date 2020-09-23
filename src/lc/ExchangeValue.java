/*
 * @Author: lsd
 * @Date: 2020-02-24 17:35:23
 * @Software: vscode
 * @Description: 
 *  不使用中间变量，交换2个变量的值
 *  
 */
package cn.andios.lc;

public class ExchangeValue {
    public static void main(String[] args) {
        //exchangeValue1(); 
        exchangeValue2(); 
    }

    private static void exchangeValue1() {
        int a = 1,b = 2;
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println("a:" + a); 
        System.out.println("b:" + b);
    }  
    
    //一个数与自己^，结果为0
    private static void exchangeValue2() {
        int a = 1,b = 2;
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("a:" + a); 
        System.out.println("b:" + b);
    }  

}