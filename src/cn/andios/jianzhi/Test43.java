/*
 * @Author: lsd
 * @Date: 2020-02-24 13:07:31
 * @Software: vscode
 * @Description: 
 */
package cn.andios.jianzhi;

public class Test43 {
    public static void main(String[] args) {
        System.out.println(new Test43().LeftRotateString("abcXYZdef", 3));
    }
    public String LeftRotateString(String str,int n) {
        if(str == null || str.length() == 0){
            //这里不能返回null，必须返回 ""
            return "";
        }
        n %= str.length();
        String str1 = str.substring(0,n);
        String str2 = str.substring(n,str.length());
        return str2 + str1;
    }
}