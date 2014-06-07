public class MinimumPathSum  {
    public int minPathSum(int[][] grid) {
        
        if(grid == null)
        System.exit(1);
        
        int m = grid.length;
        int n = grid[0].length;
        
        int[][] dpMatrix = new int[m][n];
        
        if(m<1 || n <1)
        return 0;
        
        dpMatrix[0][0] = grid[0][0];
        
        for(int i =1; i< m; i++)
        dpMatrix[i][0] = grid[i][0] + dpMatrix[i-1][0] ;
        
        for(int i =1; i< n; i++)
        dpMatrix[0][i] = grid[0][i] + dpMatrix[0][i-1] ;
        
        for(int i =1; i< m; i++)
         for(int j =1; j< n; j++){
             dpMatrix[i][j] =(int)Math.min(dpMatrix[i-1][j],dpMatrix[i][j-1]) + grid[i][j] ;
         }
         return dpMatrix[m-1][n-1];   
    }
}