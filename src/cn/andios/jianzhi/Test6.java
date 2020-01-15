/*
 * @Author: lsd
 * @Date: 2020-01-15 23:02:57
 * @Software: vscode
 * @Description: 
 *      二分查找法，定义两个指针left、right，以及mid
 *      case:
 *          mid < left   min在mid左边    right = mid
 *          mid > left   min在mid右边    left = mid+1
 *          mid = left   min可能在mid左边，也可能在右边  left = left + 1
 *          
 *          mid > right min在mid右边    left = mid + 1
 *          mid < right min在mid左边    right = mid
 *          mid = right min可能在mid左边，也可能在右边  right  = right - 1
 * 
 *          当最后只剩下2个元素时，比如[1,3],此时mid指向3，如果用left = left+1，就错了
 */
package cn.andios.jianzhi;

public class Test6 {
    public int minNumberInRotateArray(int [] array) {
        if(array  == null || array.length  == 0){
            return 0;
        }
        int left = 0,right = array.length-1;
        while(left < right){
            int mid = left + (right-left)/2;
            if(array[mid] < array[right]){
                right = mid;
            }else if(array[mid] > array[right]){
                left = mid + 1;
            }else{
                right = right - 1;
            }
        }
        return array[left];
    }
}