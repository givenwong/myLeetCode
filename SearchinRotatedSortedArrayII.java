// this time A[] may have dups
public class SearchinRotatedSortedArrayII  {
	
    public boolean search(int[] A, int target) {
       
        int front = 0;
        int end = A.length -1;
        
        while(front <= end){
          
          int m = (front+end)/2;
          
          if(A[m] == target)
                return true;
          // first half is sorted
          if(A[front] < A[m]){ // strictly less than
            
              if(A[front] <= target && target < A[m])
                  end = m-1;  // search the sorted part in next round
              else
                  front = m+1; // search the unsorted part in next round
           
          }else if(A[front] > A[m]){   // 2nd half is sorted      strictly great than
           
              if(A[m] < target && target <= A[end])
                  front = m+1;    // search the sorted part  in next round
              else 
                  end = m-1;   // search the unsorted part in next round
              
          }else{  
        	  // this is the case A[front] == A[m], then has to move front backward till they aren't dups
              front++; // skip the dups
          }
             
       }
        
        return false;
    }
}