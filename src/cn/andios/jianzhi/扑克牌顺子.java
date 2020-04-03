/*
 * @Author: lsd
 * @Date: 2020-02-24 14:56:25
 * @Software: vscode
 * @Description: 
 */
package cn.andios.jianzhi;

import java.util.Arrays;

public class 扑克牌顺子 {
    public boolean isContinuous(int [] numbers) {
        if(numbers == null || numbers.length != 5){
            return false;
        }
        Arrays.sort(numbers);
        int countOfZero = 0;
        int countOfInterval = 0;
        for(int i = 0;i <  numbers.length - 1;i ++){
            //因为总共只有4个0，已排好序，所以第5个一定不是0
            if(numbers[i] == 0){
                countOfZero ++;
                //避免连续出现2个0的情况，如果不continue，下面的判断会直接返回false
                continue;
            }
            //出现对子
            if(numbers[i] == numbers[i + 1]){
                return false;
            }
            countOfInterval += numbers[i + 1] - numbers[i] - 1;
        }
        if(countOfInterval <= countOfZero){
            return true;
        }
        return false;
    }
}