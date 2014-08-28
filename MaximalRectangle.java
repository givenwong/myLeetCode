/*Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing all ones and return its area.*/

public class MaximalRectangle  {
	
    public int maximalRectangle(char[][] matrix) {
        
        int rows = matrix.length;
        
		if(rows == 0){
			return 0;
		}
		int cols = matrix[0].length;
		
		// hOnes[i][j]: the number of continuous ones ending at j in row i 
        int[][] hOnes = new int[rows][cols];		
        
        int max = 0;
        
        for(int i=0; i<rows; i++){
        	for(int j=0; j<cols; j++){
        
        		if(matrix[i][j] == '1'){
        			if(j == 0){	
        				hOnes[i][j] = 1;
        			}else{
        				// !!
        				hOnes[i][j] = hOnes[i][j-1] + 1;
        			}
        		}
        		
        	}
        }
        
      
        for(int i=0; i<rows; i++){
        	for(int j=0; j<cols; j++){
        		
        		if(hOnes[i][j] != 0){
        			
        			int minI = i;	
        			int minRowWidth = hOnes[i][j];	
        			
        			while(minI >= 0){
        				minRowWidth = Math.min(minRowWidth, hOnes[minI][j]);
        				int area = minRowWidth * (i-minI+1);
        				max = Math.max(max, area);
        				minI--;
        			}
        			
        		}
        	}
        }
        
        return max;
    }
}