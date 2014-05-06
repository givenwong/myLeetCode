public class SudokuSolver {
    public void solveSudoku(char[][] board) {
        
        boolean result = isSolvable(board);
        
        
    }
    
    
    
    public boolean isSolvable(char[][] board){
        
        
        for(int i =0; i <= 8; i++)
            for(int j =0; j<= 8; j++){
                
                if(board[i][j] == '.'){
                    
                    for(int k =1; k<=9; k++){
                        board[i][j] = (char)(k +'0');
                        if(isValidSudoku(board)&&isSolvable(board))
                            return true;
                        board[i][j] = '.';
                    }
                 
                 return false;   
                }
                
            }
            
        return true;
    }
    

    public boolean isValidSudoku(char[][] board) {
        
        boolean[][] rowFlag = new boolean[9][9];
        boolean[][] colFlag = new boolean[9][9];
        boolean[][] gridFlag = new boolean[9][9];
        
        for(int i =0; i <= 8; i++)
            for(int j=0; j<=8;j++)
                rowFlag[i][j] = colFlag[i][j] = false;
                
                
                for(int i =0; i <= 8; i++)
                    for(int j=0; j<=8;j++){
                        
                        if(board[i][j] == '.')
                            continue;
                            
                        int content = board[i][j] -'1';
                        
                        if(rowFlag[i][content] || colFlag[j][content] || gridFlag[(j/3)*3+ i/3][content])
                            return false;
                        
                        rowFlag[i][content] = true; 
                        colFlag[j][content] =true;
                        gridFlag[(j/3)*3+ i/3][content] = true;    
                            
                        
                        
                    }
                    
                    
              return true;
        
        
        }
    
    
    public static void main(String[] args){
    	
    	SudokuSolver mySolution = new SudokuSolver();
    	
    	char[][] myBoard ={".....7..9".toCharArray(),".4..812..".toCharArray(),"...9...1.".toCharArray(),"..53...72".toCharArray(),"293....5.".toCharArray(),".....53..".toCharArray(),"8...23...".toCharArray(),"7...5..4.".toCharArray(),"531.7....".toCharArray()};
    	mySolution.solveSudoku(myBoard);
    	
    	for(int i = 0; i <= 8 ; i++){
    		 System.out.println();
    		for(int j = 0; j<= 8; j++){
    			System.out.print(myBoard[i][j]);
    		}
    	}
    }
    
}



