import java.util.*;

public class NQueens  {
    
    public ArrayList<String[]> solveNQueens(int n) {
        
        ArrayList<String[]> result = new ArrayList<String[]>();
        int[] board = new int[n];
        dfs(board,0,n,result);
       return result;   
    }
    
    public void dfs(int[] board, int rowIndex, int n, ArrayList<String[]> result){
        
        if(rowIndex == n){  // shouldn't be rowIndex == n -1    this is after the last filling not the last filling!!
             String[] temp = new String[n];
             
            for(int i = 0; i < n; i++){
               
               StringBuffer temptemp = new StringBuffer();
                 
                 for(int t = 0; t < n; t++)
                    temptemp.append('.');
               
               temptemp.setCharAt(board[i],'Q');
               
               temp[i] = temptemp.toString();
            }
            
          result.add(temp);
          return;
        }
        
        for(int i=0; i <n; i++){
            
            board[rowIndex] = i;
            
            if(isValid(board,rowIndex))
                dfs(board,rowIndex+1,n,result);
        }
            
        
    }
    
    boolean isValid(int[] board,int rowIndex){
        
        for(int i=0; i< rowIndex; i++){
            if(board[i] == board[rowIndex] || (int)Math.abs(board[i]-board[rowIndex]) == rowIndex - i)
                return false;
        }
        
        return true;
    }
    
    
}