/*
 * @Author: lsd
 * @Date: 2020-02-25 14:42:27
 * @Software: vscode
 * @Description: 
 */
package cn.andios.jianzhi;

import java.util.*;

public class Test64 {
    private int count = 0;
    //小顶堆
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
     
    //大顶堆
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1,o2)->o2-o1);
    
    public void Insert(Integer num) {
        count ++;
        //奇数，放在大顶堆,大顶堆存小数据
        if((count & 1) == 1){
            if(!minHeap.isEmpty() && minHeap.peek() < num){
                minHeap.offer(num);
                num = minHeap.poll();
            }
            maxHeap.offer(num);
        }else{
            //偶数，放在小顶堆
            if(!maxHeap.isEmpty() && num < maxHeap.peek()){
                maxHeap.offer(num);
                num = maxHeap.poll();
            }
            minHeap.offer(num);
        }
    }

    public Double GetMedian() {
        double result = 0;
        if((count & 1) == 1){
            result = maxHeap.peek();
        }else{
            result = (minHeap.peek() + maxHeap.peek()) / 2.0;
        }
        return result;
    }
}