/*
 * @Author: lsd
 * @Date: 2020-01-13 11:23:41
 * @Description: 
 * @Software: vscode
 */
package cn.andios.jianzhi;

public class Test1 {
    public boolean Find(int target, int [][] array) {
        //得到行数
        int x = array.length;
        //得到列数
        int y = array[0].length;
        //从左下角开始遍历
        int x1 = x - 1,y1 = 0;
        while(x1 >=0 && y1 < y ){
            if(array[x1][y1] == target){
                return true;
            //往上(变小)或者往右（变大）移动
            }else if(target > array[x1][y1]){
                y1 ++;
            }else{
                x1 --;
            }
        }
        return false;
    }
}