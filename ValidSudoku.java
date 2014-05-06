public class ValidSudoku {
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
}