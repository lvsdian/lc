/*
 * @Author: lsd
 * @Date: 2020-02-23 17:45:29
 * @Software: vscode
 * @Description: 
 */
package cn.andios.jianzhi;

public class Test34 {
    public int FirstNotRepeatingChar(String str) {
        if(str == null || str.length() == 0){
            return -1;
        }
        int[] arr = new int[128];
        for(int i = 0;i < str.length();i ++){
            arr[str.charAt(i)] ++;
        }
        for(int i = 0;i < str.length();i ++){
            if(arr[str.charAt(i)] == 1){
                return i;
            }
        }
        return -1;
    }
}