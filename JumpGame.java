public class JumpGame {
    public boolean canJump(int[] A) {
        
        
        if(A.length ==1)
        return true;
        
        int anchorPoint =0;
        int range =A[0]+0;
        boolean result = false;
        
        while(anchorPoint < A.length-1){
            
            if(range >= A.length-1)
                return true;
                
                int tempRange = range;
                
            for(int next = anchorPoint +1; next<= range && next < A.length-1; next++){
                  if(A[next]+next > tempRange){
                      tempRange = A[next]+next;
                      anchorPoint = next;
                  }
            }    
                
                   if(range>= tempRange)
                   break;
                   
                   range = tempRange;
        }
        
        return false;
    }
}