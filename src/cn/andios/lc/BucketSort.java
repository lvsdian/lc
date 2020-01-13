package cn.andios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/** 
 * @author LSD
 *
 * @datetime 2019年12月3日下午7:05:53
 *
 */
public class BucketSort {

	public static double[] bucketSort(double[] array) {
		// 1.得到数列的最大值和最小值		
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
		// 2.初始化桶 ，桶个数等于数组元素的个数		
		int bucketNum = array.length; 
		// 每个桶是一个LinkedList,多个桶串成一个ArrayList
		List<LinkedList<Double>> bucketList = new  ArrayList<LinkedList<Double>>(bucketNum); 
		for (int i = 0; i < bucketNum; i++) { 
			bucketList.add(new  LinkedList<Double>()); 
		} 
		// 3.遍历原始数组，将每个元素放入桶中 		
		for (int i = 0; i < array.length; i++) { 
			int num = (int) ((array[i] - min) * (bucketNum - 1) / (max-min)); 
			bucketList.get(num).add(array[i]); 
		} 
		// 4.对每个通内部进行排序 		
		for (int i = 0; i < bucketList.size(); i++) { 
			// JDK底层采用了归并排序或归并的优化版本 
			Collections.sort(bucketList.get(i)); 
		} 
		// 5.输出全部元素 		
		double[] sortedArray = new  double[array.length]; 
		int index = 0; 
		for (LinkedList<Double> list : bucketList) { 
			for (double element : list) { 
				sortedArray[index] = element; 
				index++; 
			} 
		} 
		//总时间复杂度：最好为o(n)
		return sortedArray; 
	}
	public static void main(String[] args) {
		double[] array = new  double[] { 4.12, 6.421, 0.0023, 3.0, 2.123, 8.122, 4.12, 10.09 };
		double[] sortedArray = bucketSort(array);
		System.out.println(Arrays.toString(sortedArray));
	}
}