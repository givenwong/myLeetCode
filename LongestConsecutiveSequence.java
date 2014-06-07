import java.util.*;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] num) {
     int max =1;
     
     HashSet<Integer> mySet = new HashSet<Integer>(); 
     for(int e : num)
         mySet.add(e);
         
      for(int e : num){
          int left = e-1;
          int right = e+1;
          int count =1;
          
          while(mySet.contains(left)){
              mySet.remove(new Integer(left));
              left--;
              count++;  
          }
          while(mySet.contains(right)){
              mySet.remove(new Integer(right));
              right++;
              count++;  
          }
          max = (max > count)?max:count;
      }    
     return max;
    }
}