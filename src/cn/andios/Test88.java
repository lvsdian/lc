package cn.andios;

import java.util.Arrays;

public class Test88 {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int [] tempArr = new int[m+n];
        int p1 = 0,p2 = 0,p = 0;
        while(p1 < m && p2 < n) {
        	if(nums1[p1] <= nums2[p2]) {
        		tempArr[p ++] = nums1[p1 ++];
        	}else {
        		tempArr[p ++] = nums2[p2 ++];
        	}
        }
        while(p1 < m) {
        	tempArr[p ++] = nums1[p1 ++];
        }
        while(p2 < n) {
        	tempArr[p ++] = nums2[p2 ++];
        }
        for (int i = 0; i < tempArr.length; i++) {
			nums1[i] = tempArr[i];
		}
    }
    public static void main(String[] args) {
    	int [] nums1 = {1,2,3,0,0,0};
    	int [] nums2 = {2,5,6};  
    	merge(nums1, 3, nums2, 3);
    	System.out.println(Arrays.toString(nums1));
	}
}
