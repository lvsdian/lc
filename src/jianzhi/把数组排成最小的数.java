/*
 * @Author: lsd
 * @Date: 2020-02-23 16:11:21
 * @Software: vscode
 * @Description: 
 *  先把整型数组拼成字符串数组，在将这个字符串数组排序，排序后转成字符串返回
 * 
 */
package cn.andios.jianzhi;

import java.util.Arrays;

public class 把数组排成最小的数 {
    public static void main(String[] args) {
        System.out.println(new int[]{1,2,3}.length);
    }
    public String PrintMinNumber(int [] numbers) {
        if(numbers == null ||numbers.length == 0){
            return null;
        }
        int len = numbers.length;
        StringBuffer sb = new StringBuffer();
        String[] str = new String[len];
        for(int i = 0;i < len;i ++){
            str[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(str, ((String str1,String str2)->{
                String string1 = str1 + str2;
                String string2 = str2 + str1;
                return string1.compareTo(string2);
            }
        ));

        // Arrays.sort(str,new Comparator<String>(){
        //     @Override
        //     public int compare(String s1, String s2) {
        //         String c1 = s1 + s2;
        //         String c2 = s2 + s1;
        //         return c1.compareTo(c2);
        //     }
        // });

        for(int i = 0;i < len;i ++){
            sb.append(str[i]);
        }
        return sb.toString();
    }
}