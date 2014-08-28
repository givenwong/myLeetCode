public class RemoveDuplicatesfromSortedArray {
	
    public int removeDuplicates(int[] A) {
        
        int slow =0; // slow points to the last element of the result
        int fast =1; // fast is a probe for new elements
        
        if(A == null)
        System.exit(1);
        
        if(A.length ==0)
        return 0;
        
        while(fast <= A.length -1){
       
           if(A[slow] != A[fast]){
               slow++;
               A[slow] = A[fast];
           }
           fast++;
            
        }
        // to return the length of the array
        return slow+1;   
    }
}