package cn.andios.lc;

import java.util.Arrays;

/**
 * 二叉堆：
 *	添加：将要添加的元素到最后的位置，再一次次比较并移动
 *	删除：删除根节点，最末位置的元素添加到根节点位置，再一次次比较并移动
 *	构建：所有非叶子节点从后往前比较并移动
 *二叉树是顺序存储，从上到下，从左到右
 *	左孩子下标：2*parent+1；右孩子下标：2*parent+2
 *二叉排序：将二叉堆堆顶元素与最末一个元素交换，再一次次比较并移动
 *
 *二叉排序步骤：
 *	1.构建二叉堆
 *	2.循环删除堆顶元素(其实是与末尾元素交换，不是真删除)
 * 
 * @author LSD
 *
 * @datetime 2019年12月3日下午6:10:02
 */
public class HeapSort {

	/** 
	 * 下沉调整
	 * @param array       待调整的堆
	 * 
	 * @param parentIndex 要下沉的父节点
	 * 
	 * @param parentIndex 堆的有效大小 
	 */
	public static void downAdjust(int[] array, int parentIndex, int length){
		// temp保存父节点值，用于最后的赋值
		int temp = array[parentIndex];
		int childIndex = 2 * parentIndex + 1;
		while (childIndex < length) { 
			// 如果有右孩子，且右孩子大于左孩子的值，则定位到右孩子 
			if  (childIndex +  1  < length && array[childIndex +  1]  > array[childIndex])  {
				childIndex++; 
			} 
			// 如果父节点小于任何一个孩子的值，直接跳出 
			if  (temp >= array[childIndex]) 
				break; 
			// 无需真正交换，单向赋值即可 
			array[parentIndex]  	= array[childIndex]; 
			parentIndex = childIndex; 
			childIndex = 2 * childIndex + 1;
		} 
		array[parentIndex] = temp;
	}

	/**
	 * 堆排序
	 * @param array 待调整的堆
	 */

	public static void heapSort(int[] array) {
		// 1.把无序数组构建成二叉堆。
		for  (int i = (array.length - 2) / 2; i >= 0; i--) {
			downAdjust(array, i, array.length);
		}
		System.out.println(Arrays.toString(array)); 
		// 2.循环删除堆顶元素，移到集合尾部，调节堆产生新的堆顶。 
		for  (int i = array.length - 1; i > 0; i--)  {
			// 最后一个元素和第一元素进行交换
			int temp = array[i];
			array[i] = array[0];
			array[0] = temp;
			// 下沉调整最大堆 
			downAdjust(array, 0, i); 
		} 
	} 
	public  static  void main(String[] args) { 
		int[] arr = new int[] { 1, 3, 2, 6, 5, 7, 8, 9, 10, 0 };
		heapSort(arr);
		System.out.println(Arrays.toString(arr));
	}
}