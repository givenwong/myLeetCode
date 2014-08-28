public class FirstMissingPositive {
	int firstMissingPositive(int A[]) {  
      
      int n = A.length;
      for(int i =0; i< n; i++)  {  
    	 // while can be terminated as either after some swap A[i] == i+1 or A[i] get out of range or get the duplicate 
        while(A[i] != i+1)  {        // if A[i] == A[A[i]-1] the while loops forever
          if(A[i] <= 0 || A[i] >=n+1 || A[i] == A[A[i] -1]) 
        	  break;
          // content A[i] is supposed to be at index A[i]-1
          int temp = A[i];  
          A[i] = A[temp-1];  
          A[temp-1] = temp;          
        }  
      }  
      
      for(int i =0; i< n; i++)  
       if(A[i]!=i+1)  
        return i+1;  
      // all in order
      return n+1;  
    }  
}