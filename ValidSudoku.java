public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        // the first index is row/column number
    	// the 2nd   index is the content of the board
    	// the boolean is if the content in that row/column already exists
        boolean[][] rowFlag = new boolean[9][9];
        boolean[][] colFlag = new boolean[9][9];
        boolean[][] gridFlag = new boolean[9][9];
           
                for(int i =0; i <= 8; i++)
                    for(int j=0; j<=8;j++){
                        
                        if(board[i][j] == '.')
                            continue;
                        
                        // the content is used as the index of the flag array so subtract '1'
                        int content = board[i][j] -'1';
                        
                        // i/3 is the number of rows in terms of big blocks
                        // j/3 is the number of cols in terms of big blocks
                        // each row has 3 blocks so there are (i/3)*3 blocks
                        // and plus the extra j/3 blocks
                        if(rowFlag[i][content] || colFlag[j][content] || gridFlag[(i/3)*3+ j/3][content])
                            return false;
                        
                        rowFlag[i][content] = true; 
                        colFlag[j][content] =true;
                        gridFlag[(i/3)*3+ j/3][content] = true;    
                    }
              return true;
        }
}