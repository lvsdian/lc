package cn.andios;

import java.util.Arrays;

public class MergeSort {
	public static void main(String[] args){
		int[] array ={5,8,6,3,9,2,1,7};
		mergeSort(array,0, array.length - 1);
		System.out.println(Arrays.toString(array));
	}

	private static void mergeSort(int[] array, int start, int end) {
		if(start < end) {
			int mid = (start + end)/2;
			mergeSort(array, start, mid);
			mergeSort(array, mid + 1, end);
			merge(array,start,mid,end);
		}
		
	}
	private static void merge(int[] array, int start, int mid, int end) {
		int [] tempArr = new int [end -start +1];
		int p1 = start,p2 = mid + 1,p = 0;
		while(p1 <= mid && p2 <= end) {
			if(array[p1] <= array[p2]) {
				tempArr[p ++] = array[p1++];
			}else {
				tempArr[p ++] = array[p2 ++];
			}
		}
		while(p1 <= mid) {
			tempArr[p ++] = array[p1++];
		}
		while(p2 <= end) {
			tempArr[p ++] = array[p2++];
		}
		for (int i = 0; i < tempArr.length; i++) {
			array[i + start] = tempArr[i];
		}
	}

	
}
