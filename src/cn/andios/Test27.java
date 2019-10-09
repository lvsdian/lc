package cn.andios;

public class Test27 {

	public static int removeElementWithoutSwap(int [] nums,int val) {
		/**
		 * 	利用双指针i,j，开始都指向nums[0]，
		 * 		因为不需要考虑数组中超出新长度后面的元素，所以不用交换
		 * 	因为数组中等于val的数<=nums.length,不等于val的数也<=nums.length
		 * 		所以nums[i]可用来表示所有的nums元素
		 * 		   nums[j]可用来表示nums中不等于val的元素
		 * 		   i>=j;
		 */
		int i = 0,j = 0;
		while(i < nums.length) {
			if(nums[i] != val) {
				nums[j] = nums[i];
				j ++;				
			}
			i ++;
			
		}
		return j;
	}
	
	public static int removeElement(int[] nums, int val) {
	   /**
		 * 	利用双指针i,j，开始都指向nums[0]，
		 * 		nums[i]后移，如果nums[i] != val,就将nums[i]与nums[j]交换，
		 * 				         如果nums[i] == val,nums[i]后移，nums[j]不动
		 * 	直到i移到nums.length位置。返回j。
		 * 
		 */
		int j = 0;
		for(int i = 0;i <nums.length;i ++) {
			if(nums[i] != val) {
				if(nums[i] == nums[j]) {
					j ++;
				}else {
					swap(nums, j, i);				
					j ++;
				}
				
			}
		}
		return j;
    }

	private static void swap(int[] nums, int j, int i) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	
	public static void main(String[] args) {
		int []array = {0,1,2,2,3,0,4,2}; 
		int len = removeElementWithoutSwap(array, 2);
		System.out.println("len：" + len);
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + "\t");
		}
	}
	
	
}
