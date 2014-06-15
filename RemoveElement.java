public class RemoveElement  {
	
    public int removeElement(int[] A, int elem) {
        
      int slow =0; // slow points to the next of the last valid number as no need to refer to the last valid number
      int fast =0; // the probe
      
      if(A == null)
      System.exit(1);
      
      if(A.length == 0)
      return A.length;
      
      while(fast <= A.length -1){
          
          if(A[fast] != elem){
            A[slow] = A[fast];
            fast++;
            slow++;
          }else{
              fast++;
          }          
      }
      
      return slow;
        
    }
}