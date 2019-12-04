package cn.andios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/** 
 * @author LSD
 *
 * @datetime 2019��12��3������7:05:53
 *
 */
public class BucketSort {

	public static double[] bucketSort(double[] array) {
		// 1.�õ����е����ֵ����Сֵ		
		double max = array[0];
		double min = array[0];
		for (int i = 1; i < array.length; i++) {
			if (array[i] > max) {
				max = array[i];
			}
			if (array[i] < min) {
				min = array[i];
			}
		} 
		// 2.��ʼ��Ͱ ��Ͱ������������Ԫ�صĸ���		
		int bucketNum = array.length; 
		// ÿ��Ͱ��һ��LinkedList,���Ͱ����һ��ArrayList
		List<LinkedList<Double>> bucketList = new  ArrayList<LinkedList<Double>>(bucketNum); 
		for (int i = 0; i < bucketNum; i++) { 
			bucketList.add(new  LinkedList<Double>()); 
		} 
		// 3.����ԭʼ���飬��ÿ��Ԫ�ط���Ͱ�� 		
		for (int i = 0; i < array.length; i++) { 
			int num = (int) ((array[i] - min) * (bucketNum - 1) / (max-min)); 
			bucketList.get(num).add(array[i]); 
		} 
		// 4.��ÿ��ͨ�ڲ��������� 		
		for (int i = 0; i < bucketList.size(); i++) { 
			// JDK�ײ�����˹鲢�����鲢���Ż��汾 
			Collections.sort(bucketList.get(i)); 
		} 
		// 5.���ȫ��Ԫ�� 		
		double[] sortedArray = new  double[array.length]; 
		int index = 0; 
		for (LinkedList<Double> list : bucketList) { 
			for (double element : list) { 
				sortedArray[index] = element; 
				index++; 
			} 
		} 
		//��ʱ�临�Ӷȣ����Ϊo(n)
		return sortedArray; 
	}

	public static void main(String[] args) {
		double[] array = new  double[] { 4.12, 6.421, 0.0023, 3.0, 2.123, 8.122, 4.12, 10.09 };
		double[] sortedArray = bucketSort(array);
		System.out.println(Arrays.toString(sortedArray));
	}
}
