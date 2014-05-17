import java.util.*;

public class LRUCache {
    
    int cap;
    HashMap<Integer, Integer> myHashMap = new HashMap<Integer, Integer>(); // key-value
    ArrayList<Integer> myArrayList = new ArrayList<Integer>();// key
  
  
  public LRUCache(int capacity) {
      
   this.cap = capacity;
      
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
             this.myArrayList.add(new Integer(key));
             }else{
             this.myHashMap.put(key,value);
             this.myArrayList.add(new Integer(key));
             }
             
            
         }else{
             if(this.myHashMap.get(key) != null){
                 
             this.myHashMap.put(key,value);
             this.myArrayList.remove(new Integer(key));
             this.myArrayList.add(new Integer(key));
             
             }else{
             
             this.myHashMap.remove(myArrayList.get(0));
             this.myHashMap.put(key,value);
             this.myArrayList.remove(0);
             this.myArrayList.add(key);
          
             }
             
         }    
         
         
         
      
  }
  
  
  public static void main(String[] args){
  	LRUCache myLRUCache = new LRUCache(1);
  	myLRUCache.set(2, 1);
  	int myResult = myLRUCache.get(2);
  	System.out.println(myResult);
  	
  }
}