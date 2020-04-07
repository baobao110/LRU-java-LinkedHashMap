package com.demo.lru;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Auther chenhao
 * @Date 2020/4/7
 * https://blog.csdn.net/wangshione/article/details/6700985
 * https://www.jianshu.com/p/b8b00da28a49
 */
public class LRUCache<K,V> extends LinkedHashMap<K,V>{

    private int size;

    public LRUCache(int size){
        super(16, 0.75f, true);
        this.size = size;
    }

    //如果加入的元素大于最大数目。此时返回true,这时会删除第一个元素，就是最近最少连接数
    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size()>size;
    }

    public static void main(String[] args) {
        LRUCache<String,Object> cache=new LRUCache<String, Object>(4);
        cache.put("a",1);
        cache.put("b",2);
        cache.put("c",3);
        cache.put("d",4);
        System.out.println(cache.toString());
        cache.get("a");
        System.out.println(cache.toString());
        cache.put("e",5);
        System.out.println(cache.toString());
    }
}
