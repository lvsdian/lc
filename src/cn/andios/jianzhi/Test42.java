/*
 * @Author: lsd
 * @Date: 2020-02-24 11:51:52
 * @Software: vscode
 * @Description: 
 */
package cn.andios.jianzhi;

import java.util.ArrayList;

public class Test42 {
    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (array == null || array.length < 2) {
            return list;
        }
        int i=0,j=array.length-1;
        while(i<j){
            if(array[i]+array[j]==sum){
            list.add(array[i]);
            list.add(array[j]);
                return list;
           }else if(array[i]+array[j]>sum){
                j--;
            }else{
                i++;
            }
             
        }
        return list;
    }
}