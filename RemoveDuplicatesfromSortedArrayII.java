public class RemoveDuplicatesfromSortedArrayII  {
    public int removeDuplicates(int[] A) {
        
        if(A == null )
        System.exit(1);
        
        if(A.length ==0)
        return 0;
        
        
        if(A.length ==1)
        return 1;
    
        
        int slow =0;
        int fast =1;
        boolean reachMax = false;
        
        while(fast < A.length){
            
            if(A[slow] == A[fast] && reachMax){
                fast++;
               continue;
            }
            
            if(A[slow] != A[fast]){
                A[++slow] = A[fast++];
                reachMax = false;
                continue;
            }
            
            
            if(A[slow] == A[fast]&& !reachMax){
                  A[++slow] = A[fast++];
                  reachMax = true;
            }
            
        } 
        
        return slow+1;
    }
    

}