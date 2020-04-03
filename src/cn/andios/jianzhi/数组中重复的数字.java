/*
 * @Author: lsd
 * @Date: 2020-02-24 17:56:41
 * @Software: vscode
 * @Description: 
 *  比如[2,3,1,0,2,5,3]
 *  初始i = 0,num[i]为2，2 != i，2 != num[2] ,就把2与num[2]交换，得到[1,3,2,0,2,5,3]
 *  此时i = 0,num[i]为1，1 != i，1 != num[1] ,就把1与num[1]交换，得到[3,1,2,0,2,5,3]
 *  此时i = 0,num[i]为3，3 != i，3 != num[3] ,就把3与num[3]交换，得到[0,1,2,3,2,5,3]
 *  此时i = 0,num[i]为0，0 == i，i ++
 *  此时i = 1,num[i]为1，1 == i，i ++
 *  此时i = 2,num[i]为2，2 == i，i ++
 *  此时i = 3,num[i]为3，3 == i，i ++
 *  此时i = 4,num[i]为2，2 != i，2 == num[2]，找到了，返回
 */
package cn.andios.jianzhi;

public class 数组中重复的数字 {
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if(numbers == null || numbers.length < 2){
            return false;
        }
        for(int i = 0;i < numbers.length;i ++){
            while(numbers[i] != i){
                if(numbers[i] == numbers[numbers[i]]){
                    duplication[0] = numbers[i];
                    return true;
                }
                int tmp = numbers[i];
                numbers[i] = numbers[numbers[i]];
                numbers[tmp] = tmp;
                //numbers[numbers[i]] = tmp;
            }
        }
        return false;
    }
}