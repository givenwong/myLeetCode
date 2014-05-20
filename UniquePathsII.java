public class UniquePathsII  {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        
         if(obstacleGrid == null)
         System.exit(1);
         
         int m = obstacleGrid.length;
         int n = obstacleGrid[0].length;
         
         int[][] dpMatrix = new int[m][n];
         
        if(m<1 || n <1)
        return 0;
        
        
        if(m ==1){
            for(int i =0; i < n; i++){
                if(obstacleGrid[0][i] == 1)
                    return 0;
            }
            
            return 1;
        }
        
          if(n ==1){
            for(int i =0; i < m; i++){
                if(obstacleGrid[i][0] == 1)
                    return 0;
            }
            
            return 1;
        }
        
        
        
           if(obstacleGrid[0][0] ==1){
            dpMatrix[0][0] =0;
            return 0;
               
           }else
            dpMatrix[0][0] =1;
            
          
           for(int i =1; i < m; i++){
                if(obstacleGrid[i][0] == 1)
                    dpMatrix[i][0] =0;
                else
                    dpMatrix[i][0] = dpMatrix[i-1][0];
            }
        
             for(int i =1; i < n; i++){
                if(obstacleGrid[0][i] == 1)
                    dpMatrix[0][i] =0;
                else
                    dpMatrix[0][i] = dpMatrix[0][i-1];
            }
            
             for(int i =1; i< m; i++)
             for(int j =1; j< n; j++){
             if(obstacleGrid[i][j] == 0)
             dpMatrix[i][j] =dpMatrix[i-1][j]+dpMatrix[i][j-1];
             else{
                dpMatrix[i][j] = 0; 
             }
                 
             }
             
             return dpMatrix[m-1][n-1];

    
        
    }
}