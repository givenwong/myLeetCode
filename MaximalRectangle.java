public class MaximalRectangle  {
    public int maximalRectangle(char[][] matrix) {
        
        int rows = matrix.length;
		if(rows == 0){
			return 0;
		}
		int cols = matrix[0].length;
		
		// hOnes[i][j]: the number of continuous ones ending at i,j in row i 
        int[][] hOnes = new int[rows][cols];		
        
        int max = 0;
        for(int i=0; i<rows; i++){
        	for(int j=0; j<cols; j++){
        		if(matrix[i][j] == '1'){
        			if(j == 0){	
        				hOnes[i][j] = 1;
        			}else{
        				hOnes[i][j] = hOnes[i][j-1] + 1;
        			}
        		}
        	}
        }
        
        // the max happens at the most right column
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