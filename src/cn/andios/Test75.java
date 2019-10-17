package cn.andios;

import java.util.Arrays;

public class Test75 {

    public static void sortColors(int[] nums) {
    	 //  0...lt  lt+1...gt-1  gt...nums.length
        int lt = -1;
        int gt = nums.length;
        int i = 0;
        while(i < gt){
            if(nums[i] == 0){
                lt ++;
                swap(nums,lt,i);
                i ++;
            }else if(nums[i] == 1){
                i ++;
            }else if(nums[i] == 2){
                gt --;
                swap(nums,gt,i);
            }
        }
    }
	public static void main(String[] args) {
		int [] array = {0,1,0,1,0,0,2,0,1,0,2};
		sortColors(array);
		System.out.println(Arrays.toString(array));
	}
	

	private static void swap(int [] nums,int a,int b){
	    int temp = nums[a];
	    nums[a] = nums[b];
	    nums[b] = temp;
	}
}
