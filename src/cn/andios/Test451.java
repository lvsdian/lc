package cn.andios;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

/**
 * 
 * @author LSD
 *
 * @datetime 2019��12��4������11:26:54
 *
 */
public class Test451 {
	
	/**
	 * 	�������滻hashmap��Ч�ʸ���
	 * 
	 * 	1.��������ͳ��ÿ����ĸ���ֵ�Ƶ�ʣ�
	 * 	2.����Ƶ�ʷ������ȼ�����(�ŵ������е�����ĸ��Ӧ������ֵ)
	 * 	3.���γ��ӣ����ݳ��ӵ�Ԫ����ԭ�������ҵ���Ӧ��Ƶ�ʣ�ƴ�ӳ��ַ���
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
