/*
 * @Author: lsd
 * @Date: 2020-02-23 13:53:33
 * @Software: vscode
 * @Description:
 *  
 *  对于arr[0]，最大就是arr[0]
 *      arr[1],最大要么是arr[1],要么是arr[1]前面的最大+arr[1]
 *      arr[2],最大要么是arr[2],要么是arr[2]前面的最大+arr[2]
 * 
 *      所以arr[i]的最大为Math.max(arr[i],arr[i]前面的最大+arr[i]);
 */
package cn.andios.jianzhi;

public class Test30 {
    public int FindGreatestSumOfSubArray(int[] array) {
        int result = array[0];
        int max = array[0];
        for(int i = 1;i < array.length;i ++){
            max = Math.max(max + array[i],array[i]);
            result = Math.max(result,max);
        }
        return result;
    }
}