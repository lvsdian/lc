package cn.andios;
public class BinSearch {
	//����
	public static void main(String[] args) {
		int[] arr = {0,1,2,3,4,5,6,7,8,9};
		//����ұ����� [0, arr.length - 1]
		int index = binSearch(arr, 0, arr.length - 1, 0);
		System.out.println("�±꣺" + index);
	}

	private static int binSearch(int[] arr, int l, int r, int target) {
		if(r < l)
			return -1;
		int mid = (l + r)/2;
		if(arr[mid] == target)
			return mid;
		if(arr[mid] < target)
			return binSearch(arr, mid + 1, r, target);
		else
			return binSearch(arr, l, mid - 1, target);
	
	}

	


}
