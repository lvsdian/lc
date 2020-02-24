/*
 * @Author: lsd
 * @Date: 2020-02-24 17:51:55
 * @Software: vscode
 * @Description: 
 */
package cn.andios.jianzhi;

public class Test49 {
    public int StrToInt(String str) {
        if(str == null || str.trim().length() == 0){
            return 0;
        }
        //是否带正负号
        boolean isNeg = false;
        if(str.charAt(0) == '+'){
            str = str.substring(1);
        }else if(str.charAt(0) == '-'){
            isNeg = true;
            str = str.substring(1);
        }
        //转为数组
        char[] s = str.toCharArray();
        long res = 0L;
        //如果有一位不是数字，直接返回
        for(int i = 0;i < s.length;i ++){
            if(!Character.isDigit(s[i])){
                return 0;
            }else{
                //累加结果
                res += Math.pow(10,s.length - i -1)  * (s[i] -48);
            }
        }
        if(isNeg == false){
            if(res > Integer.MAX_VALUE){
                return 0;
            }else{
                return (int)res;
            }
        }else{
            if((-res)<Integer.MIN_VALUE){
                return 0;
            }else{
                return (int)(-res);
            }
        }
    }
}