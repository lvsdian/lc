/*
 * @Author: lsd
 * @Date: 2020-02-21 18:46:00
 * @Software: vscode
 * @Description: 
 *  比如 1100，右移一位得到 0110,
 *                       & 1100
 *                       --------
 *                         0100，与1100相比少了一个1，所以一个数不为0，能 & 多少次就有多少个1
 *       
 */
package cn.andios.jianzhi;

public class Test11 {
    public int NumberOf1(int n) {
        int count = 0;
        while(n != 0){
            count ++;
            n = n & (n - 1);
        }
        return count;
    }
}