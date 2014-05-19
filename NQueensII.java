public class NQueensII {
    
    int numResult =0;
    
    public int totalNQueens(int n) {
        
        int[] board = new int[n];
        
        dfs(board,0,n);
        
        return this.numResult;
    }
    
    public void dfs(int[] board, int rowIndex, int n){
        
        if(rowIndex == n){
         numResult++;
         return;
        }
        
        for(int i=0;i< n; i++){
             board[rowIndex] = i;
            if(isValid(board, rowIndex))
                dfs(board,rowIndex+1,n);
    }
}
  public boolean isValid(int[] board, int rowIndex){
      
      for(int i=0; i< rowIndex; i++){
          if(board[i] == board[rowIndex] || (int)Math.abs(board[i]-board[rowIndex]) == rowIndex -i)
               return false;
      }
    
    return true;
  }
}