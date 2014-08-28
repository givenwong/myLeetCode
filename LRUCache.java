/*
 * Design and implement a data structure for Least Recently Used (LRU) cache. 
 * It should support the following operations: get and set.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
set(key, value) - Set or insert the value if the key is not already present. 
When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.*/
import java.util.*;
public class LRUCache {
      int cap;
      // hashmap is for Cache's storage
      // arraylist is for items' recencies
      HashMap<Integer, Integer> myHashMap; // key-value
      ArrayList<Integer> myArrayList; // key
    public LRUCache(int capacity) {    // this is the constructor
     this.cap = capacity;
     myHashMap = new HashMap<Integer, Integer>(); // key-value
     myArrayList = new ArrayList<Integer>();// key
    }
    
    public int get(int key) {    
        if(this.myHashMap.get(key) == null)
            return -1;
        
        this.myArrayList.remove(new Integer(key));
        this.myArrayList.add(new Integer(key));
        return   this.myHashMap.get(key).intValue(); 
    }
    
    public void set(int key, int value) {
    	
              if(this.myHashMap.size()< this.cap){ 
            	  
               if(this.myHashMap.get(key) != null){
               this.myHashMap.put(key,value);
               this.myArrayList.remove(new Integer(key));
               this.myArrayList.add(key);
               }else{
               this.myHashMap.put(key,value);
               this.myArrayList.add(key);
               }
           }else{
               if(this.myHashMap.get(key) != null){
               this.myHashMap.put(key,value);
               this.myArrayList.remove(new Integer(key));
               this.myArrayList.add(key);
               }else{
               this.myHashMap.remove(myArrayList.get(0));
               this.myHashMap.put(key,value);
               this.myArrayList.remove(0); // remove entry with index =0
               this.myArrayList.add(key);
               }  
           }        
    } 
}