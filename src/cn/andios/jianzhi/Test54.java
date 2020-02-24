/*
 * @Author: lsd
 * @Date: 2020-02-24 21:46:30
 * @Software: vscode
 * @Description: 
 */
package cn.andios.jianzhi;

import java.util.*;

public class Test54 {
    String str = "";
    Map<Character,Integer> map = new HashMap<>();
    //Insert one char from stringstream
    public void Insert(char ch)
    {
        if(!map.containsKey(ch)){
            map.put(ch,1);
        }else{
            map.put(ch,map.get(ch) +1);
        }
        str += ch;
    }
  //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        int index = Integer.MAX_VALUE;
        char result = '#';
        for(Character c : map.keySet()){
            if(map.get(c) == 1){
                if(str.indexOf(c) < index){
                    index = str.indexOf(c);
                    result = str.charAt(index);
                }
            }
        }
        return result;
    }
}