public class SearchinRotatedSortedArrayII  {
    public boolean search(int[] A, int target) {
        
        
        // first step: to find the greatest number  has to use binary search
        
        int front = 0;
        int end = A.length -1;
        
    
        while(front <= end){
          
          int m = (front+end)/2;
          if(A[m] == target)
                return true;
          
          // first half is sorted
          if(A[front] < A[m]){
            
              if(A[front] <= target && target < A[m])
                  end = m-1;  // search the sorted part in next round
              else
                  front = m+1; // search the unsorted part in next round
             
              
              
          }else if(A[front] > A[m]){   // 2nd half is sorted
             
              
              if(A[m] < target && target <= A[end])
                  front = m+1;    // search the sorted part  in next round
              else 
                  end = m-1;   // search the unsorted part in next round
              
          }else{  
              front++; // skip the dups
          }
          
            
        }
        
        return false;
    }
}