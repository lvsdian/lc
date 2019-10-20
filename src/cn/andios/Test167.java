package cn.andios;

import java.util.Arrays;
/**
 * ����ָ����ײ��
 * @author LSD
 *
 * @datetime 2019��10��20������2:21:51
 *
 */
public class Test167 {

    public static int[] twoSum(int[] numbers, int target) {
        int i = 0,j = numbers.length - 1;
        if(numbers == null || numbers.length <2) {
        	return null;
        }
        int []a = new int [2];
        while(i < j) {
        	if(numbers[i] + numbers[j] == target) {
	        	a[0] = i + 1;
	        	a[1] = j + 1;
	        	return a;
        	}else if(numbers[i] + numbers[j] > target){
        		j --;
        	}else {
        		i ++;
        	}
        }
        
        return null;
    }
	//����
	public static void main(String[] args) {
		int []array = {0,1,2,3,4,5,6};
		int [] a = twoSum(array, 3);
		System.out.println(Arrays.toString(a));
		
	}
}
