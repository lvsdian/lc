package cn.andios;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 88 75 215
 * @author LSD
 *
 * @datetime 2019年10月20日下午3:27:11
 *
 */
public class Test215 {

	/**
	 * 	优先级队列api
	 *	Time Complexity：O(nlgk)
	 *	Space Complexity：O(k)
	 */
	public static int findKthLargest3(int[] nums, int k) {
		 final PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
		    for(int val : nums) {
		    	//所有元素插入到队列中
		    	priorityQueue.offer(val);
		        if(priorityQueue.size() > k) {
		        	//头元素出队
		        	priorityQueue.poll();
		        }
		    }
		    //返回头元素
		    return priorityQueue.peek();
	}

	/**
	 * 	非空判断,k是否合法判断...
	 * 
	 * 	Space Complexity：O(nlgn)  
	 * 	Space Complexity：O(1)
	 */
	public static int findKthLargest2(int[] nums, int k) {
		//排序，直接返回
		int N = nums.length;
        Arrays.sort(nums);
        return nums[N - k];
	}
	
	/**
	 *	 非空判断,k是否合法判断...
	 * 
	 *	 Space Complexity：O(n)
	 *	 Space Complexity：O(1)
	 */
    public static int findKthLargest1(int[] nums, int k) {
    	if(nums == null || nums.length == 0 || nums.length < k) {
    		return 0;
    	}
    	int start = 0,end = nums.length - 1;
        int index = partition(nums,start,end,k);
        return index;
    }
    private static int partition(int[] nums,int start,int end,int k) {
    	int pivot = nums[start];
    	int left = start,right = end;
    	if(start < end) {
        	while(left != right) {
        		while(nums[right] > pivot && left < right) {
        			right --;
        		}
        		while(nums[left] <= pivot && left < right) {
        			left ++;
        		}
        		if(left < right) {
        			swap(nums, left, right);
        		}
        	}
        	swap(nums, start, left);
        	//执行到这里，left的左边<=nums[left],left的右边>nums[left]
        	
        	/**
        	 * nums[left]表示的是第 end-left+1大的数
        	 */
        	int temp = end - left +1;
        	//碰巧找到了
        	if(k == temp) {
        		return nums[left];
        	}
        	
        	/**
        	 * 	要找的数在右边，比如left=2,若end=5，则temp=4,left的index为2，表示第3小的数，表示第4大的数，
        	 * 	若k=3(k要保证<temp),则在left的右边找第3大的数。
        	 */
        	else if(k < temp) {
        		return partition(nums, left + 1, end, k);
        	}
        	/**
        	 * 	要找的数在左边，比如left=2,若end=5，start=0,则temp=4,left的index为2，表示第3小的数，表示第4大的数，
        	 * 	若k=5(k要保证>temp),则在left的左边(0-1)找第1大(k-temp)的数。
        	 */
        	else{
        		return partition(nums, start, left - 1, k-temp);
            }
    	}else {
    		return pivot;
    	}

	}
    private static void swap(int [] arr,int a,int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	public static void main(String[] args) {
    	int [] nums = {3,2,1,5,6,4};
    	//int e = findKthLargest1(nums, 2 );
    	//int e = findKthLargest2(nums, 2 );
    	int e = findKthLargest3(nums, 2 );
    	System.out.println("e：" + e);
	}
}