public class WordSearch {
	
    public boolean exist(char[][] board, String word) {
   
        int rowNum = board.length;
        int colNum = board[0].length;
        
        for(int i =0; i< rowNum; i++)
        for(int j=0; j< colNum; j++){
        	// dfs doesn't change the board. i,j is the entry point to search for the word
            if(dfs(board,i,j,0,word)) 
            return true;
        }
        return false;
    }
    
    public boolean dfs(char[][] board, int i, int j, int index, String word){
        
        int rowNum = board.length;
        int colNum = board[0].length;
        int wordLength = word.length();
        
        if(index >= wordLength)
        return true;
        
        if(i>= rowNum || i <= -1 || j >= colNum || j <= -1 || board[i][j] != word.charAt(index))
        return false;
        
        char temp = board[i][j];
        board[i][j] = '@'; // this char can't be used more than once
        boolean result = dfs(board, i+1,j,index+1,word)||dfs(board, i-1,j,index+1,word)||dfs(board, i,j-1,index+1,word)||dfs(board, i,j+1,index+1,word);
        board[i][j] = temp; // make sure dfs doesn't change the board
        
        return result;    
    }
}