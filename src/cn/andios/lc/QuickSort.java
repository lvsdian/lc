package cn.andios;

import java.util.Arrays;

/**
 * 	双指针、挖坑、三路快排
 * 
 * @author LSD
 *
 * @datetime 2019年10月13日下午6:02:49
 *
 */
public class QuickSort {

	public static void main(String[] args) {
		int[] arr = new int[] {1,0,1,2,1,0};
		quickSortDoublePtr(arr, 0, arr.length - 1);
//		sonOfQuickSort3(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}
	
	private static void quickSortDoublePtr(int[] arr, int start, int end) {
		if(start < end) {
			int index = partition(arr,start,end);
			quickSortDoublePtr(arr, start, index - 1);
			quickSortDoublePtr(arr, index +1, end);
		}
	}


	private static void sonOfQuickSort3(int[] arr, int start, int end) {
		// start...lt  	lt+1...gt-1   	 gt...end
		// l...lt 		lt+1...gt-1 	 gt...r
		int lt = start - 1; 
		int gt = end + 1;
		int i = 0;
		while(i < gt) {
			if(arr[i] == 0) {
				lt ++;
				swap(arr, i, lt);
				i ++;
			}else if(arr[i] == 1) {
				i ++;
			}else if(arr[i] == 2) {
				gt --;
				swap(arr, i, gt);
			}
		}
	}

	private static int partition(int[] arr, int start, int end) {
		int index = arr[start];
		int left = start,right = end;
		while(left != right) {
			while(left < right && arr[right] > index) {
				right --;
			}
			while(arr[left] <= index && left < right) {
				left ++;
			}
			if(left < right) {
				swap(arr, left, right);
			}
		}
		swap(arr, left, start);
		
		return left;
	}

	private static void swap(int [] arr,int a,int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
}