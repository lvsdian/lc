/*
 * @Author: lsd
 * @Date: 2020-02-23 21:49:14
 * @Software: vscode
 * @Description: 
 */
package cn.andios.jianzhi;

public class Test37 {     
    public static void main(String[] args) {
        System.out.println(new Test37().GetNumberOfK1(new int []{1,2,2,3}, 2)); ;
    }
    //方法1，找到k,然后向前向后找，最坏情况：lgn + n
    //方法二，二分查找找到第一个n,二分查找找到最后一个k，总共2lgn,即lgn
    public int GetNumberOfK1(int [] array , int k) {
    if(array == null || array.length == 0){
        return 0;
    }
    int index = binSearch(array,k,0,array.length - 1);
     if(index < 0)
         return 0;
     int count = 0;
     //index后面的k
     for(int i = index;i <array.length && array[i] == k;i ++){
         count ++;
     }
     //index前面的k
     for(int i = index  - 1;i >= 0 && array[i] == k;i --){
         count ++;
     }
     return count;
 }
 private int binSearch(int[] array,int target,int start,int end){
     if(start > end){
         return -1;
     }
     int mid = start + (end - start) / 2;
     if(array[mid] == target){
         return mid;
     }else if(array[mid] > target){
         if(array[0] < array[array.length - 1]){//升序
             return binSearch(array,target,0,mid - 1);
         }else{
             return binSearch(array,target,mid + 1,end);
         }
     }else{
         if(array[0] < array[array.length - 1]){//升序
             return binSearch(array,target,mid + 1,end);
         }else{
             return binSearch(array,target,0,mid - 1);
         }
     }
 }
}