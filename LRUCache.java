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
        this.myArrayList.add(key);
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