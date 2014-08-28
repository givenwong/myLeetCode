/*
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

For example:
Given array A = [2,3,1,1,4]

The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
*/

public class JumpGameII {
    public int jump(int[] A) {
        
        int anchorPoint =0; // current position
        int numJumps = 0;
      
        if(A == null)
        System.exit(1);
        
        if(A.length == 0)
        return 0;
        
        if(A.length == 1)
        return 0;
        
        int range =A[anchorPoint]+anchorPoint;  
        while(anchorPoint<A.length-1){            
            if(range >= A.length-1)
                return numJumps+1;
            
            int tempRange =A[anchorPoint]+anchorPoint;    
            for(int j =anchorPoint+1; j <= range && j < A.length-1; j++ ){
                  if(tempRange < A[j] + j){
                    tempRange = A[j] + j;
                    anchorPoint=j;     
                  }    
            }
            numJumps++;
            range = tempRange;   
        }
        return numJumps ;
    }
}
