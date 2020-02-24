/*
 * @Author: lsd
 * @Date: 2020-02-24 21:21:42
 * @Software: vscode
 * @Description: 
 * 
 *   1. 正负号只能出现在第一个位置或者e/E后一个位置
 *   2. e/E后面有且必须有整数
 *   3. 字符串中只能包含数字、小数点、正负号、e/E，其它的都是非法字符
 *   4. e/E的前面最多只能出现一次小数点，而e/E的后面不能出现小数点
 */
package cn.andios.jianzhi;

public class Test53 {
    public boolean isNumeric(char[] str) {
        if(str == null || str.length == 0){
            return false;
        }
    
        boolean signed = false;        //标识是否以正负号开头
        boolean decimal = false;       //标识是否有小数点
        boolean existE = false;        //是否含有e/E
        int start = -1;                //一段连续数字的开头
        int index = 0;                 //从0开始遍历字符
    
        if(existSignAtIndex(str, 0)){
            signed = true;
            index++;
        }
    
        while(index < str.length){
            //以下按照index上可能出现的字符进行分支判断
            if(str[index] >= '0' && str[index] <= '9'){
                start = (start == -1) ? index : start;
                index++;
    
            }else if(str[index] == '+' || str[index] == '-'){
                //首字符的+-我们已经判断过了，因此+-只可能出现在e/E的后面
                if(!existEAtIndex(str, index - 1)){
                    return false;
                }
                index++;
    
            }else if(str[index] == '.'){
                //小数点只可能出现在e/E前面，且只可能出现一次
                //如果出现过小数点了，或者小数点前一段连续数字的前面是e/E
                if(decimal || existEAtIndex(str, start - 1)
                   || existEAtIndex(str, start - 2) ){
                    return false;
                }
                decimal = true;//出现了小数点
                index++;
                //下一段连续数字的开始
                start = index;
    
            }else if(existEAtIndex(str, index)){
                if(existE){
                    //如果已出现过e/E
                    return false;
                }
                existE = true;
                index++;
                //由于e/E后面可能是正负号也可能是数字，所以下一段连续数字的开始不确定
                start = !existSignAtIndex(str, index) ? index : index + 1;
    
            }else{
                return false;
            }
        }
    
        //如果最后一段连续数字的开始不存在 -> e/E后面没有数字
        if(start >= str.length){
            return false;
        }
    
        return true;
    }
    
    //在index上的字符是否是e或者E
    public boolean existEAtIndex(char[] str, int index){
        if(str == null || str.length == 0 || index < 0 || index > str.length - 1){
            return false;
        }
        return str[index] == 'e' || str[index] == 'E';
    }
    
    //在index上的字符是否是正负号
    public boolean existSignAtIndex(char[] str, int index){
        if(str == null || str.length == 0 || index < 0 || index > str.length - 1){
            return false;
        }
        return str[index] == '+' || str[index] == '-';
    }
}