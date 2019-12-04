package cn.andios;

import java.util.Arrays;

/**
 * ����ѣ�
 *	��ӣ���Ҫ��ӵ�Ԫ�ص�����λ�ã���һ�δαȽϲ��ƶ�
 *	ɾ����ɾ�����ڵ㣬��ĩλ�õ�Ԫ����ӵ����ڵ�λ�ã���һ�δαȽϲ��ƶ�
 *	���������з�Ҷ�ӽڵ�Ӻ���ǰ�Ƚϲ��ƶ�
 *��������˳��洢�����ϵ��£�������
 *	�����±꣺2*parent+1���Һ����±꣺2*parent+2
 *�������򣺽�����ѶѶ�Ԫ������ĩһ��Ԫ�ؽ�������һ�δαȽϲ��ƶ�
 *
 *���������裺
 *	1.���������
 *	2.ѭ��ɾ���Ѷ�Ԫ��(��ʵ����ĩβԪ�ؽ�����������ɾ��)
 * 
 * @author LSD
 *
 * @datetime 2019��12��3������6:10:02
 */
public class HeapSort {

	/** 
	 * �³�����
	 * @param array       �������Ķ�
	 * 
	 * @param parentIndex Ҫ�³��ĸ��ڵ�
	 * 
	 * @param parentIndex �ѵ���Ч��С 
	 */
	public static void downAdjust(int[] array, int parentIndex, int length){
		// temp���游�ڵ�ֵ���������ĸ�ֵ
		int temp = array[parentIndex];
		int childIndex = 2 * parentIndex + 1;
		while (childIndex < length) { 
			// ������Һ��ӣ����Һ��Ӵ������ӵ�ֵ����λ���Һ��� 
			if  (childIndex +  1  < length && array[childIndex +  1]  > array[childIndex])  {
				childIndex++; 
			} 
			// ������ڵ�С���κ�һ�����ӵ�ֵ��ֱ������ 
			if  (temp >= array[childIndex]) 
				break; 
			// ������������������ֵ���� 
			array[parentIndex]  	= array[childIndex]; 
			parentIndex = childIndex; 
			childIndex = 2 * childIndex + 1;
		} 
		array[parentIndex] = temp;
	}

	/**
	 * ������
	 * @param array �������Ķ�
	 */

	public static void heapSort(int[] array) {
		// 1.���������鹹���ɶ���ѡ�
		for  (int i = (array.length - 2) / 2; i >= 0; i--) {
			downAdjust(array, i, array.length);
		}
		System.out.println(Arrays.toString(array)); 
		// 2.ѭ��ɾ���Ѷ�Ԫ�أ��Ƶ�����β�������ڶѲ����µĶѶ��� 
		for  (int i = array.length - 1; i > 0; i--)  {
			// ���һ��Ԫ�غ͵�һԪ�ؽ��н���
			int temp = array[i];
			array[i] = array[0];
			array[0] = temp;
			// �³��������� 
			downAdjust(array, 0, i); 
		} 
	} 
	public  static  void main(String[] args) { 
		int[] arr = new int[] { 1, 3, 2, 6, 5, 7, 8, 9, 10, 0 };
		heapSort(arr);
		System.out.println(Arrays.toString(arr));
	}
}
