package cn.andios;
/**
 * 27,26,80,238
 * @author LSD
 *
 * @datetime 2019年10月10日下午5:00:23
 *
 */
public class Test80 {

    public static int removeDuplicates(int[] nums) {
  
    	if(nums == null || nums.length == 0)
    		//return -1;  不能返回-1
    		return 0;
    	//计数相等元素的个数
    	int j = 1;
    	//k为新数组的下标
    	int k = 1;
    	int p = nums[0];
    	for(int i = 1;i < nums.length;i ++) {
    		if(nums[i] != p) {
    			//碰到和p不相等的，就存到新数组中
    			nums[k ++] = nums[i];
    			//下次再判断是，就判断是不是和新的p相等
    			p = nums[i];
    			//和p相等的元素个数是1，就是他自身
    			j =1;
    		}else {
    			//碰到nums[i]与p相等
    			j ++;
    			//此时与p相等的元素有两个，保存到新数组中
    			if(j == 2) {
    				nums[k ++] = nums[i];
    			}
    			//如果与p相等的元素大于两个，不考虑
    		}
    	}
        return k;  
    }
	
	public static void main(String[] args) {
		int [] array = {};
		int len = removeDuplicates(array);
		System.out.println("len：" + len);
		for(int j = 0;j <len;j ++) {
			System.out.print(array[j] + "\t");
		}
	}
}
