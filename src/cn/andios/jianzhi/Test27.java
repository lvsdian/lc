/*
 * @Author: lsd
 * @Date: 2020-02-22 22:36:35
 * @Software: vscode
 * @Description: 
 *  
 * 全排列问题，将字符串分为两部分，第一部分：第一个元素，第二部分，其他元素。
 * 
 * 全排列问题：所有可能出现在第1个位置的记录，与剩下的元素的全排列
 * 
 * 比如2,3,4，5全排列，在3,4，5中选1个数与2交换，这个数可以是3或4或5，比如选3，就将2,4,5全排列
 * 
 * 
 */
package cn.andios.jianzhi;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
public class Test27 {    
public static void main(String[] args) {
    new Test27().Permutation("abc");
}
public ArrayList<String> Permutation(String str) {
    ArrayList<String> list = new ArrayList<>();
    if(str == null || str.length() == 0){
       return list;
    }
    helper(str.toCharArray(),0,str.length() - 1,list);
    Collections.sort(list);
    return list;
 }
 public void helper(char[] str,int start,int end,ArrayList<String> list){
     if(start == end){
         String string = new String(str);
         if(!list.contains(string)){
             list.add(string);
         }
         
     }
     //从start到end，每个元素都可能出现在第1个位置上，所以从start-end遍历
     for(int i = start;i <= end;i ++){
         swap(str,start,i);
         //start位置元素确定了，剩下的元素全排列
         helper(str,start + 1,end,list);
         //第二次swap还原状态
         swap(str,start,i);
     }
 }
 private void swap(char[] str,int i,int j){
     if(i != j){
         char tmp = str[i];
         str[i] = str[j];
         str[j] = tmp;
     }
 }
}