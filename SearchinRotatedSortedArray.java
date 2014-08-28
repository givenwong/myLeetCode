public class SearchinRotatedSortedArray  {
	
    public int search(int[] A, int target) {    
        // first step: to find the greatest number  has to use binary search
        int front = 0;
        int end = A.length -1;
        
        while(front <= end){  
        	
          int m = (front+end)/2;
          
          if(A[m] == target)
                return m;
          
          // first half is sorted
          if(A[front] <= A[m]){
              // has to discuss two cases  A[front] <= A[m] V.S. A[front] > A[m]
        	  // otherwise the "if(A[front] <= target && target < A[m])" is nonsense
              if(A[front] <= target && target < A[m])
                  end = m-1;  // search the sorted part in next round
              else
                  front = m+1; // search the unsorted part (the 2nd half) in next round
        
          }else{   // 2nd half is sorted
                      
              if(A[m] < target && target <= A[end])
                  front = m+1;    // search the sorted part  in next round
              else 
                  end = m-1;   //    search the unsorted part (the first half) in next round
              
          }
      
        }
        
        return -1;
    }
}
