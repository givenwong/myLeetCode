/*
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

For example:
A = [2,3,1,1,4], return true.

A = [3,2,1,0,4], return false*/

public class JumpGame {
    public boolean canJump(int[] A) {
        
        if(A.length ==1)
        return true;
        
        int anchorPoint =0;
        int range =A[0]+0;
        boolean result = false;
        
        // try all points untill the 2nd last point!
        while(anchorPoint < A.length-1){
            
            if(range >= A.length-1)
                return true;
                
            int tempRange = range;    
            for(int next = anchorPoint +1; next<= range && next < A.length-1; next++){
                  if(A[next]+next > tempRange){
                	  // update the next step's range and anchorPoint
                      tempRange = A[next]+next;
                      anchorPoint = next;
                  }
            }    
                
           if(range>= tempRange)
           break;
           
           // update the range in the greedy manner
           range = tempRange;
        }  
        
        return false;
    }
}