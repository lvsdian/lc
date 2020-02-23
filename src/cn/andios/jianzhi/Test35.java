/*
 * @Author: lsd
 * @Date: 2020-02-23 20:36:58
 * @Software: vscode
 * @Description: 
 * 
 * 借助归并排序
 */
package cn.andios.jianzhi;

public class Test35 {
    public int count;
    public int InversePairs(int [] array) {
        if(array == null || array.length == 0){
            return 0;
        }
        MergeSort(0,array.length - 1,array);
        return count;
    }
    //归并排序
    public void MergeSort(int start,int end,int[] array){
        if(start >= end){
            return;
        }
        int mid = start + (end - start)/2;
        MergeSort(start,mid,array);
        MergeSort(mid + 1,end,array);
        merge(start,mid,end,array);
    }
    public void merge(int start,int mid,int end,int []array){
        int[] tmpArr = new int[end -start + 1];
        int p1 = start,p2 = mid + 1,k = 0;
        while(p1 <= mid && p2 <= end){
            if(array[p1] <= array[p2]){
                tmpArr[k ++] = array[p1 ++];
            }else{
                tmpArr[k ++] = array[p2 ++];
                count = (count + (mid - p1 + 1)) % 1000000007;
            }
        }
        while(p1 <= mid){
            tmpArr[k ++] = array[p1 ++];
        }
        while(p2 <= end){
            tmpArr[k ++] = array[p2 ++];
        }
        for(int i = 0;i < k;i ++){
            array[start + i] = tmpArr[i];
        }
    }
}