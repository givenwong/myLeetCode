public class WordSearch {
    public boolean exist(char[][] board, String word) {
   
        int rowNum = board.length;
        int colNum = board[0].length;
        
        for(int i =0; i< rowNum; i++)
        for(int j=0;j< colNum;j++){
            if(dfs(board,i,j,0,word)) // dfs doesn't change the board
            return true;
        }
        return false;
    }
    
    
    public boolean dfs(char[][] board, int i, int j, int start, String word){
        
        int rowNum = board.length;
        int colNum = board[0].length;
        int wordLength = word.length();
        
        if(start >= wordLength)
        return true;
        
        if(i>= rowNum || i <= -1 || j >= colNum || j <= -1 || board[i][j] != word.charAt(start))
        return false;
        
        char temp = board[i][j];
        board[i][j] = '@'; // this char cant be used more than twice
        boolean result = dfs(board, i+1,j,start+1,word)||dfs(board, i-1,j,start+1,word)||dfs(board, i,j-1,start+1,word)||dfs(board, i,j+1,start+1,word);
        board[i][j] = temp; // make sure dfs doesn't change the board
        
        return result;    
    }
}