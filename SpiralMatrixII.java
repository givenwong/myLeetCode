// to put 1...n*n in the the matrix in the spiral order: from outer loop to the inner loop
public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        
        int[][] result = new int[n][n];
        helper(result, 1, 0, n-1, 0, n-1);
        return result;
    }
        
    public void helper(int[][] matrix, int startNum, int left, int right, int high, int low){
           
        if(right < left || low < high){
            return;
        }
         
        if(right == left && low == high){
            matrix[high][left] = startNum;
            return;
        }
        
        if(left == right && high < low){
            for(int i = high; i <= low; i++){
               matrix[i][left]= startNum++;
            }
            return;
        }
        
        if(left < right && high == low){
            for(int i = left ; i <= right; i++){
           matrix[high][i]= startNum++;
            }
            return;
        }
        // corner cases above
        for(int i = left; i<= right;i++){
            matrix[high][i]= startNum++;
        }
        
        for(int i = high+1; i<= low;i++){
            matrix[i][right]= startNum++;
        }
        
         for(int i = right-1; i >= left;i--){
            matrix[low][i]= startNum++;
        }
       
         for(int i = low-1; i > high;i--){
            matrix[i][left]= startNum++;
        }
        
        helper(matrix, startNum,left+1, right-1, high+1, low-1);
    }
}