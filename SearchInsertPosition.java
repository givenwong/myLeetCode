public class SearchInsertPosition  {
    public int searchInsert(int[] A, int target) {
        
        
        int front = 0;
        int end = A.length -1;
        
        while(front <= end){
            
            int mid = (front+end)/2;
            
            
            if(A[mid] == target)
                return mid;
            
            
            if(A[mid] < target)
                front = mid +1;
            else
                end = mid-1;
            
        }
        
        return front;
        
        
        
    }
}