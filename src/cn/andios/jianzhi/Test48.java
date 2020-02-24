/*
 * @Author: lsd
 * @Date: 2020-02-24 17:05:51
 * @Software: vscode
 * @Description: 
 * 
 *                  比如计算  5 + 7
 *                   101 
 *                   111
 *  先计算非进位为：  010
 *          进位为：1010
 *          相加为：1100，即12
 *          010相当于101与111异或
 *         1010相当于101与111与操作，再左移1
 *          
 *          多次仅此上述运算，当进位为0时，非进位即为结果
 */
package cn.andios.jianzhi;

public class Test48 {
    public int Add(int num1,int num2) {
        int result = 0;
        int carry = 0;
        do{
            result = num1 ^ num2;
            carry = (num1 & num2) << 1;
            num1 = result;
            num2 = carry;
        }while(carry != 0);
        return result;
    }
}