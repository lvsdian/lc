/*
 * @Author: lsd
 * @Date: 2020-02-24 13:18:17
 * @Software: vscode
 * @Description: 
 */
package cn.andios.jianzhi;

public class 翻转单词序列 {
    public String ReverseSentence1(String str) {
        //注意判空
        if(str == null || str.trim().length() == 0){
            return str;
        }
        String strs[] = str.split(" ");
        String tmp = null;
        StringBuffer sb = new StringBuffer();
        for(int i = 0;i < strs.length >> 1;i ++){
            tmp = strs[i];
            strs[i] = strs[strs.length - i - 1];
            strs[strs.length - i - 1] = tmp;
        }
        for(int i = 0;i < strs.length;i ++){
            sb.append(strs[i]);
            sb.append(" ");
        }
        return sb.substring(0, sb.length() - 1);
    }


    public String ReverseSentence2(String str) {
        if(str.trim().equals("")){
            return str;
        }
        String[] a = str.split(" ");
        StringBuffer o = new StringBuffer();
        int i;
        for (i = a.length; i >0;i--){
            o.append(a[i-1]);
            if(i > 1){
                o.append(" ");
            }
        }
        return o.toString();
    }
}