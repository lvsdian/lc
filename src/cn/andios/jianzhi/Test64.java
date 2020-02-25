/*
 * @Author: lsd
 * @Date: 2020-02-25 14:57:13
 * @Software: vscode
 * @Description: 
 */
package cn.andios.jianzhi;

import java.util.*;

public class Test65 {
    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> list = new ArrayList<>();
        if(num == null || num.length == 0 || size <= 0 || size > num.length){
            return list;
        }
        PriorityQueue<Integer> maxQueue = new PriorityQueue<Integer>((o1,o2)->o2-o1);//大顶堆
        int count = 0;
        while(count < size){
            maxQueue.offer(num[count]);
            count ++;
        }
        list.add(maxQueue.peek());
        //i从1到num.length-size
        for(int i=1;i<num.length+1-size;i++){
            maxQueue.remove(num[i-1]);
            maxQueue.offer(num[i+size-1]);
            list.add(maxQueue.peek());
        }
        return list;
        
    }
}