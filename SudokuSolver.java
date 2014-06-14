public class SudokuSolver {
	
    public void solveSudoku(char[][] board) {
        
        boolean result = isSolvable(board);
    }
    
    // dfs 
    public boolean isSolvable(char[][] board){
        
        for(int i =0; i <= 8; i++)
            for(int j =0; j<= 8; j++){
                
                if(board[i][j] == '.'){
                    
                    for(int k =1; k<=9; k++){
                    	// casting
                        board[i][j] = (char)(k +'0'); 
                        
                        if(isValidSudoku(board)&&isSolvable(board)) // dfs modifies board[][] if it is a solution
                            return true;
                        
                        board[i][j] = '.'; // dfs doesn't modify board[][] if it is not a solution and try the next one
                    }
                 
                 // this position can't be filled with any number so it can't be solved
                 return false;   
                }
                
            }
        
        
        
        // this is the base case: board[][] is fully filled  so the nested for loop is not executed 
        // then come to here
        return true;
    }
    
    public boolean isValidSudoku(char[][] board) {
        
        boolean[][] rowFlag = new boolean[9][9];
        boolean[][] colFlag = new boolean[9][9];
        boolean[][] gridFlag = new boolean[9][9];
                    
                for(int i =0; i <= 8; i++)
                    for(int j=0; j<=8;j++){
                        
                        if(board[i][j] == '.')
                            continue;
                            
                        int content = board[i][j] -'1';
                        
                        if(rowFlag[i][content] || colFlag[j][content] || gridFlag[(i/3)*3+ j/3][content])
                            return false;
                        
                        rowFlag[i][content] = true; 
                        colFlag[j][content] =true;
                        gridFlag[(i/3)*3+ j/3][content] = true;    
                                
                    }
                       
              return true;
        }    
}
