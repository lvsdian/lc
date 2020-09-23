/*
 * @Author: lsd
 * @Date: 2020-02-24 15:20:16
 * @Software: vscode
 * @Description: 
 *      约瑟夫环问题
 */
package cn.andios.jianzhi;

import java.util.LinkedList;

public class 圆圈中最后剩下的数 {
    public int LastRemaining_Solution(int n, int m) {
        LinkedList<Integer> list = new LinkedList<>();
        for(int i = 0;i < n;i ++){
            list.add(i);
        }
        int remove = 0;
        while(list.size() > 1){
            remove = (remove + m - 1) % list.size();
            list.remove(remove);
        }
        return list.size() == 1 ? list.get(0) : -1;
    }
}