/*
 * @Author: lsd
 * @Date: 2020-02-24 11:21:18
 * @Software: vscode
 * @Description: 
 *  
 * 滑动窗口
 */
package cn.andios.jianzhi;

import java.util.ArrayList;

public class 和为S的连续正数序列 {
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
         if(sum <=2){
             return result;
         }
         int p1 = 1,p2 = 2;
         int cur = 0;
         while(p1 < p2){
             cur = (p1 + p2)*(p2 - p1 + 1) / 2;
             if(cur == sum){
                 ArrayList<Integer> list = new ArrayList<>();
                 for(int i = p1;i <= p2;i ++){
                     list.add(i);
                 }
                 result.add(list);
                 p1 ++;
             }else if(cur < sum){
                 p2  ++;
             }else{
                 p1 ++;
             }
         }
         return result;
     }
}