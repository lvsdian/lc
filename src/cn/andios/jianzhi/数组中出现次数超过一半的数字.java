/*
 * @Author: lsd
 * @Date: 2020-02-23 00:10:52
 * @Software: vscode
 * @Description: 
 */
package cn.andios.jianzhi;

public class 数组中出现次数超过一半的数字 {
    public int MoreThanHalfNum_Solution(int [] array) {
        if(array == null || array.length == 0){
            return 0;
        }
        int  preVal = array[0];
        int count = 1;
        for(int i = 1;i < array.length;i ++){
            if(array[i] == preVal){
                count ++;
            }else{
                count --;
                if(count <=0){
                    preVal = array[i];
                }
            }
        }
        count = 0;
        //判断这个数是否存在
        for(int i = 0;i < array.length;i ++){
            if(array[i] == preVal){
                count ++;
            }
        }
        return count > array.length / 2 ? preVal : 0;
    }
}