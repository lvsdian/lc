/*
 * @Author: lsd
 * @Date: 2020-02-24 15:56:48
 * @Software: vscode
 * @Description: 
 *      
 *      （首项+尾项）*项数 / 2
 */
package cn.andios.jianzhi;

public class 求1到n的和 {
    public int Sum_Solution(int n) {
        int sum = n * (n + 1);
        return sum >> 1;
    }
}