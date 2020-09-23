/*
 * @Author: lsd
 * @Date: 2020-01-13 15:57:38
 * @Description: 
 * @Software: vscode
 */
package cn.andios.lc;
public class BinSearch {
	//测试
	public static void main(String[] args) {
		int[] arr = {0,1,2,3,4,5,6,7,8,9};
		//左闭右闭区间 [0, arr.length - 1]
		int index = binSearch(arr, 0, arr.length - 1, 0);
		System.out.println("下标：" + index);
	}

	private static int binSearch(int[] arr, int l, int r, int target) {
		if(r < l)
			return -1;
		//int mid = (l + r)/2; //这种写法当l、r足够大时，l+r可能会整型溢出
		int mid = l + (r-l)/2;
		if(arr[mid] == target)
			return mid;
		if(arr[mid] < target)
			return binSearch(arr, mid + 1, r, target);
		else
			return binSearch(arr, l, mid - 1, target);
	}
}