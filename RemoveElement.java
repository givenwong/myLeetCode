public class RemoveElement  {
    public int removeElement(int[] A, int elem) {
        
      int slow =0;
      int fast =0;
      
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