package cn.andios;
/**
 * 27,26,80,238
 * @author LSD
 *
 * @datetime 2019��10��10������5:00:23
 *
 */
public class Test80 {

    public static int removeDuplicates(int[] nums) {
  
    	if(nums == null || nums.length == 0)
    		//return -1;  ���ܷ���-1
    		return 0;
    	//�������Ԫ�صĸ���
    	int j = 1;
    	//kΪ��������±�
    	int k = 1;
    	int p = nums[0];
    	for(int i = 1;i < nums.length;i ++) {
    		if(nums[i] != p) {
    			//������p����ȵģ��ʹ浽��������
    			nums[k ++] = nums[i];
    			//�´����ж��ǣ����ж��ǲ��Ǻ��µ�p���
    			p = nums[i];
    			//��p��ȵ�Ԫ�ظ�����1������������
    			j =1;
    		}else {
    			//����nums[i]��p���
    			j ++;
    			//��ʱ��p��ȵ�Ԫ�������������浽��������
    			if(j == 2) {
    				nums[k ++] = nums[i];
    			}
    			//�����p��ȵ�Ԫ�ش���������������
    		}
    	}
        return k;  
    }
	
	public static void main(String[] args) {
		int [] array = {};
		int len = removeDuplicates(array);
		System.out.println("len��" + len);
		for(int j = 0;j <len;j ++) {
			System.out.print(array[j] + "\t");
		}
	}
}
