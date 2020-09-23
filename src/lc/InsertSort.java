/*
 * @Author: lsd
 * @Date: 2020-01-23 20:05:35
 * @Software: vscode
 * @Description: 
 */
package cn.andios.lc;

public class InsertSort {

    public static void main(String[] args) {
        int [] arr = new int []{1,2,5,3,8,5,9,0};
        insertSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+"\t");
        }
    }
    public static void insertSort(int []arr){
        if(arr == null || arr.length < 2){
            return;
        }
        //[0,i-1]位置为已经排好序的数组，初始时i为1，即第一个元素是排好序的
        for(int i = 1;i < arr.length;i ++){
            //temp记录arr[i]的值
            int temp = arr[i];
            //在已经排好序的[0,i-1]位置中找到合适的位置将arr[i]插进去，这个位置为insertIndex
            int insertIndex = getInsertIndex(0,i - 1,arr,arr[i]);
            //[insertIndex,i-1]位置元素后移
            for (int j = i; j > insertIndex; j--) {
                arr[j] = arr[j - 1];
            }
            arr[insertIndex] = temp;

        }
    }

    private static int getInsertIndex(int i, int j, int[] arr, int value) {
        
        while(i <= j){
            int mid = i + (j - i)/2;
            if(value > arr[mid]){
                i = mid + 1;
            }else{
                j = mid - 1;
            }
        }
        return i;
    }
}