package cn.andios;

/**
 * 209 3 438 76
 * @author LSD
 *
 * @datetime 2019年11月17日下午6:39:49
 *
 */
public class Test209 {

    public static int minSubArrayLen(int s, int[] nums) {
    	if(nums == null || nums.length == 0)
    		return 0;
    	int l = 0,r = -1;//滑动窗口[l,r],左闭右闭区间
    	int sum = 0; //滑动窗口内元素的和
    	int res = nums.length + 1;//滑动窗口内元素个数
    	while(l < nums.length) {
    		//r+1 < nums.length：后面会进行r++，所以要保证r++ < s.length()
    		//sum < s：如果区间[l,r]的和<s
    		if(r+1 < nums.length && sum < s) {
    			//r指针右移，把r++位置值加到sum中
    			r ++;
    			sum += nums[r];
    		//如果区间[l,r]的和>=s：左指针右移，sum减去l位置值
    		}else {
    			sum -= nums[l];
    			l ++;
    		}
    		if(sum >= s) {
    			res = Math.min(res, r-l+1);
    		}
    		
    	}
    	if(res == nums.length + 1) {
    		return 0;
    	}
        return res;
    }
	
	public static void main(String[] args) {
		int length = minSubArrayLen(7, new int []{2,3,1,2,4,3});
		System.out.println(length);
	}
}
