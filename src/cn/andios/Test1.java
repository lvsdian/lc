package cn.andios;

import java.util.HashMap;
import java.util.Map;

public class Test1 {
	
	public static void main(String[] args) {
		int a[] = twoSum(new int[]{3,2,2,6},4);
		System.out.println(a[0]+""+a[1]);
	}
	
	public static int[] twoSum(int[] nums, int target) {
		 Map<Integer,Integer> map = new HashMap<Integer,Integer>();
			for(int i = 0;i < nums.length;i ++){								
				if(map.containsKey(target - nums[i])){
					return new int[] {map.get(target - nums[i]),i};
				} 
				map.put(nums[i],i);						
			}	      
			return new int[] {-1,-1};
	}
}