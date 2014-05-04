public class RemoveDuplicatesfromSortedArray {
    public int removeDuplicates(int[] A) {
        
        int slow =0;
        int fast =0;
        
        
        if(A == null)
        System.exit(1);
        
        if(A.length ==0)
        return 0;
        
        
        while(fast <= A.length -1){
            
           if(slow ==0 && fast == 0){
            fast++;
            continue;
            }
            
           if(A[slow] != A[fast]){
               slow++;
               A[slow] = A[fast];
               fast++;
           }else{
               fast++;
           }
            
        }
        
        return slow+1;
        
        
    }
    

}