/*
 * @Author: lsd
 * @Date: 2020-02-22 17:53:51
 * @Software: vscode
 * @Description: 
 */
package cn.andios.lc;

import java.util.LinkedHashMap;
import java.util.Map;

public class Test146 {
    
}
class LRUCache {

    private Map<Integer,Integer> map;
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new LinkedHashMap(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return map.size() > capacity;
            }
        };
    }

    public int get(final int key) {
        return map.getOrDefault(key, -1);
    }

    public void put(final int key, final int value) {
        map.put(key,value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */