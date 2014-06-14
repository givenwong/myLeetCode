import java.util.*;

public class SpiralMatrix  {
	
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        if(matrix == null || matrix.length ==0)
        return result;
        
        int left =0;
        int right = matrix[0].length-1;
        int high =0;
        int low = matrix.length-1;
        
        helper(matrix, left, right , high, low, result);
        return result;
    }
    
    
    public void helper(int[][] matrix, int left, int right, int high, int low, ArrayList<Integer> result){
        
        if(right < left || low < high){ // this corner case is non trivial
            return;
        }
        
        if(right == left && low == high){
            result.add(matrix[left][high]);
            return;
        }
        
        
        if(left == right && high < low){
            for(int i = high; i <= low; i++){
                result.add(new Integer(matrix[i][left]));
            }
            return;
        }
        
        if(left < right && high == low){
            for(int i = left ; i <= right; i++){
                result.add(matrix[high][i]);
            }
            return;
        }
        // corner cases above
        for(int i = left; i<= right;i++){
            result.add(matrix[high][i]);
        }
        
        for(int i = high+1; i<= low;i++){
            result.add(matrix[i][right]);
        }
        
         for(int i = right-1; i >= left;i--){
            result.add(matrix[low][i]);
        }
       
         for(int i = low-1; i >= high+1;i--){
            result.add(matrix[i][left]);
        }
    
       helper(matrix, left+1, right-1, high+1, low-1, result);
    }
    
}