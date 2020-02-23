/*
 * @Author: lsd
 * @Date: 2020-02-23 15:17:58
 * @Software: vscode
 * @Description: 
 *      个位：k = n % 10，    n / 10    * 1    + if(k >= 1   ) 1     else if(k < 1   ) 0 else k - 1      + 1
 *      十位：k = n % 100，   n / 100   * 10   + if(k >= 19  ) 10    else if(k < 10  ) 0 else k - 10     + 1
 *      百位：k = n % 1000，  n / 1000  * 100  + if(k >= 199 ) 100   else if(k < 100 ) 0 else k - 100    + 1
 * 
 * 所以：x位  k = n % 10x     n / 10x  * x  + if(k >= 2x-1   ) x    else if(k < x   ) 0 else k - x  + 1
 */
package cn.andios.jianzhi;

public class Test31 {
    public static void main(String[] args) {
       int a = new Test31().NumberOf1Between1AndN_Solution(21345);
       System.out.println(a);
    }
    public int NumberOf1Between1AndN_Solution(int n) {
        if(n <=0){
            return 0;
        }
        int count = 0;
        int tmp = 0;
        //从个、十、百到...小于n的最大10的倍数位
        for(int i = 1;i <= n;i = i * 10){
            tmp = 0;
            int k = n % (10 * i);
            //保存上述公式中的 n / 10x  * x
            tmp = n / (10 * i) * i;
            //根据余数情况计算后续1的位数
            if(k > 2 * i -1){
                count += tmp + i;
            }else if(k < i){
                count += tmp;
            }else{
                count += tmp + k -i + 1;
            }
        }    
        return count;

    }
}