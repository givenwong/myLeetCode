import java.util.*;

public class LongestConsecutiveSequence {
	
    public int longestConsecutive(int[] num) {
    int max =1;
     // Why HashSet? dups don't count!
     HashSet<Integer> mySet = new HashSet<Integer>(); 
     
     for(int e : num)
         mySet.add(e);
         
      for(int e : num){
          
    	  int left = e-1;
          int right = e+1;
          int count =1;
          
          while(mySet.contains(left)){
              mySet.remove(new Integer(left)); // can't be used for the 2nd time as they are just one consecutive sequence
              left--;                          // so remove it from the hash set
              count++;  
          }
          while(mySet.contains(right)){
              mySet.remove(new Integer(right));
              right++;
              count++;  
          }
          
          max = (max>count)?max:count;
      }    
      
     return max;
    }
}