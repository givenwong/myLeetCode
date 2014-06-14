public class SetMatrixZeroes  {
	
    public void setZeroes(int[][] matrix) {
         
       // use the first row/col to save if this col/row should be wiped out 
       // use two extra vars to save if the first row/col should be wiped out	
       boolean firstRowFlag =false;
       boolean firstColFlag =false;
       
       for(int i= 0; i <matrix.length;i++){
           if(matrix[i][0] ==0)
    	   firstColFlag  = true; 
       } 
       
       for(int i= 0; i <matrix[0].length;i++){
           if(matrix[0][i] ==0)
    	   firstRowFlag  = true; 
       } 
       
        for(int i =1; i< matrix.length;i++)
            for(int j=1;j<matrix[0].length;j++){
                if(matrix[i][j] == 0){
                matrix[i][0] =0;
                matrix[0][j] =0;
                }
            }
            
          // in the following: i shouldn't start from zero. Why? it'll destroy the flags in the first row/col   
          for(int i =1; i< matrix.length;i++)
            if(matrix[i][0] == 0) // matrix[i][0] itself is zero OR in row i, there is a zero 
            for(int j=0;j<matrix[0].length;j++){
                        matrix[i][j] =0;
                }
                
           for(int i =1; i< matrix[0].length;i++)
            if(matrix[0][i] == 0)
            for(int j=0;j<matrix.length;j++){
                        matrix[j][i] =0;
                }        
        
        if(firstColFlag)
        for(int i= 0; i <matrix.length;i++){
            matrix[i][0] =0; 
        }    
        
        if(firstRowFlag)
            for(int i= 0; i <matrix[0].length;i++){
                matrix[0][i] =0; 
            }  
    
    }
        
}