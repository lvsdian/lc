package cn.andios;

import java.util.Arrays;

public class MergeSort {
	static public void mergeSort(int[] array,int start,int end) {
		if (start <end) {
			// �۰������С���ϣ��ֱ���еݹ�
			int mid = (start + end) / 2;
			mergeSort(array, start, mid);
			mergeSort(array, mid + 1,end);
			// ����������С���ϣ��鲢��һ���󼯺�
			merge(array, start, mid,end);
		}
	}
	static private void merge(int[] array,int start,int mid,int end) {
		// ���ٶ���󼯺ϣ�����ָ��
		int[] tempArray =new int[end - start + 1];
		int p1 = start, p2 = mid + 1, p = 0;
		// �Ƚ�����С���ϵ�Ԫ�أ����η���󼯺�
		while (p1 <= mid && p2 <= end) {
			if (array[p1] <= array[p2])
				tempArray[p++] = array[p1++];
			else
				tempArray[p++] = array[p2++];
		}
		// ���С���ϻ���ʣ�࣬���η���󼯺�β��
		while (p1 <= mid)
			tempArray[p++] = array[p1++];
		// �Ҳ�С���ϻ���ʣ�࣬���η���󼯺�β��
		while (p2 <= end)
			tempArray[p++] = array[p2++];
		// �Ѵ󼯺ϵ�Ԫ�ظ��ƻ�ԭ����
		for(int i = 0; i < tempArray.length; i++)
			array[i + start] = tempArray[i];
	}

	public static void main(String[] args){
		int[] array ={5,8,6,3,9,2,1,7};
		mergeSort(array,0, array.length - 1);
		System.out.println(Arrays.toString(array));
	}
}
