/*
 * @Author: lsd
 * @Date: 2020-02-23 12:41:17
 * @Software: vscode
 * @Description: 
 *      
 *      找出最小的k个数
 */
package cn.andios.jianzhi;

import java.util.ArrayList;

public class 最小的k个数 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new 最小的k个数().GetLeastNumbers_Solution(new int[]{4,5,1,6,2,7,3,8},4);
        list.forEach(System.out::println);
    }
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if(input == null || input.length == 0 || k > input.length || k <= 0){
            return list;
        }
        int start = 0,end = input.length - 1;
        //找出最小的k个数
        int index = partition(input,start,end,k );
        System.out.println("k:"+ k);
        System.out.println("index:"+ index);
        for(int i = 0;i < index;i ++){
            list.add(input[i]);
        }
        return list;
    }
    private int partition(int[] input,int start,int end,int k){
        int pivot = input[start];
        int left = start,right = end;
        if(start < end){
            while(left != right){
                while(input[right] > pivot && left < right){
                    right --;
                }
                while(input[left] <= pivot && left < right){
                    left ++;
                }
                if(left < right){
                    swap(input,left,right);
                }
            }
            swap(input,left,start);

            /**
             * 比如input为[1,3,5,2,8,12,10]
             *      left = 4,值为8，第5小
             *      如果k=2,最小2个数，找第3小的数，在left左边找k即可
             *      如果k=4,最小4个数，找第5小的数，即left
             *      如果k=6,最小6个数，找第7小的数，left为第5小，即在left右边找第2小的数
             */
            if(k == left){
                return left;
            }else if(k > left){
                return partition(input,left + 1,end,k - left);
            }else{
                return partition(input,start,left - 1,k);
            }
        }else{
            return pivot;
        }
    }
    private  void swap(int [] arr,int a,int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
}