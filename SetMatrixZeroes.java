public class SetMatrixZeroes  {
    public void setZeroes(int[][] matrix) {
        
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
            
            
          for(int i =1; i< matrix.length;i++)
            if(matrix[i][0] == 0)
            for(int j=1;j<matrix[0].length;j++){
                        matrix[i][j] =0;
                }
                
           for(int i =1; i< matrix[0].length;i++)
            if(matrix[0][i] == 0)
            for(int j=1;j<matrix.length;j++){
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
        
  public static void main(String[] args){
	  Solution mySolution = new Solution();
	  int[][] myMatrix = {{1,2,3,4},{5,0,5,2},{8,9,2,0},{5,7,2,1}};
	  mySolution.setZeroes(myMatrix);
	  System.out.println(myMatrix);
  }  
}