/*
 * Given a sorted array of integers, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].
*/
public class SearchforaRange  {
	// the way to return more than one values:
	// 1 array
	// 2 passing the reference of an object
    public int[] searchRange(int[] A, int target) {
        
        int[] result = new int[2];
        result[0] = searchBound(A, 0, A.length-1,true, target);
        result[1] = searchBound(A, 0, A.length-1, false, target);
             
         return result;
    }
  
  // search Bound is a dfs  
  public int searchBound( int[] A, int front, int end, boolean isLeft, int target ){
     
      int i = front;
      int j = end;
      
      while(i <= j){
          
           int mid = (i+j)/2;
          
      if(A[mid] == target ){
          if(isLeft){
              if(mid == front || A[mid] > A[mid-1])
                return 
                		mid;
              else 
                return 
                		searchBound( A, front, mid-1, true, target );
          }else{
                if(mid == end || A[mid] < A[mid+1])
                return 
                		mid;
              else 
                return 
                		searchBound( A, mid+1, end, false, target );
          }
          
      }else{
          if(A[mid] > target ){
              j = mid-1;
          }else{
              i = mid+1;
          }
      }
    }
      return -1;
  }    
  
}