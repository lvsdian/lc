package cn.andios;


public class BinSearch {

	public static int binSearch(int arr[],int l,int r,int target) {
		if(l > r)
			return -1;
		int mid = (l+r)/2;
		if(arr[mid] == target)
			return mid;
		if(arr[mid] < target) 
			//因为区间为左闭右闭，arr[mid]已经不符合，所以是mid+1和mid-1
			return binSearch(arr, mid+1,r , target);
		else
			return binSearch(arr, l, mid-1, target);			
	}
	//测试
	public static void main(String[] args) {
		int[] arr = {0,1,2,3,4,5,6,7,8,9};
		//区间左闭右闭   [0,arr.length - 1]
		int index = binSearch(arr, 0, arr.length - 1, 10);
		System.out.println("下标：" + index);
	}
}
