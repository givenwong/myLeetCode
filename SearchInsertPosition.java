/*Given a sorted array and a target value, return the index if the target is found. 
 * If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Here are few examples.
[1,3,5,6], 5 → 2
[1,3,5,6], 2 → 1
[1,3,5,6], 7 → 4
[1,3,5,6], 0 → 0
*/
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
        
        // why front but not end? 
        // if the target is not found in the 2nd last round it should be A[front] < target < A[end] and front + 1 = end
        // so in the next round mid = (front + end)/2 = front  and because A[mid] < target so front = mid +1
        // so front = end (the original end), in the next round  mid = (end+ end)/2 = end so A[mid] > target so
        // end = mid -1 = the ORIGINAL front and it is strictly less than the current front so loop ends and comes to the
        // return and should return the original end which is the current front
        return front;
     
    }
}