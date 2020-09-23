/*
 * @Author: lsd
 * @Date: 2020-01-13 15:57:38
 * @Description: 
 * @Software: vscode
 */
package cn.andios.lc;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

/**
 * 
 * @author LSD
 *
 * @datetime 2019年12月4日上午11:26:54
 *
 */
public class Test451 {
	
	/**
	 * 	用数组替换hashmap，效率更高
	 * 
	 * 	1.先用数组统计每个字母出现的频率，
	 * 	2.根据频率放入优先级队列(放到队列中的是字母对应的整型值)
	 * 	3.依次出队，根据出队的元素在原数组中找到对应的频率，拼接成字符串
	 */
    public static String frequencySort2(String s) {

    	char[] sArr = s.toCharArray();
    	int arr[] = new int [128];
    	for (int i = 0; i < sArr.length; i++) {
			arr[sArr[i]]++;
		}
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> {return arr[b] -arr[a];}) ;
        
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]>0) {
				priorityQueue.add(i);
			}
			
		}
		
        StringBuffer sb = new StringBuffer();
        int index,n;
        while(!priorityQueue.isEmpty()) {
        	index = priorityQueue.poll();
			n = arr[index];
			for (int j = 0; j < n; j++) {
				sb.append((char)index);
			}
        }
    	return sb.toString();
    }
	
    /**
     * hashmap priorityQueue
     */
    public static String frequencySort1(String s) {

    	char[] sArr = s.toCharArray();
    	
    	Map<Character,Integer> map = new HashMap<>();
    	for (int i = 0; i < sArr.length; i++) {
			map.put(sArr[i], map.getOrDefault(sArr[i], 0)+1);
		}
  	
		PriorityQueue<Map.Entry<Character,Integer>> priorityQueue = new PriorityQueue<>((a, b) -> {return b.getValue() -a.getValue();}) ;
        
		priorityQueue.addAll(map.entrySet());
        
        StringBuffer sb = new StringBuffer();
        while(!priorityQueue.isEmpty()) {
        	Map.Entry<Character, Integer> entry = priorityQueue.poll();
        	for (int i = 0; i < entry.getValue(); i++) {
        		sb.append(entry.getKey());
			}    	
        }
    	return sb.toString();
    }
    
    public static void main(String[] args) {
		//System.out.println(frequencySort1("tree"));
		System.out.println(frequencySort2("tree"));
	}

}
