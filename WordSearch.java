/*Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, 
where "adjacent" cells are those horizontally or vertically neighboring. 
The same letter cell may not be used more than once.

For example,
Given board =

[
  ["ABCE"],
  ["SFCS"],
  ["ADEE"]
]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.

*/
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
        
        // all chars from the string are found in the board 
        if(index >= wordLength)
        return true;
                                                              // requirement: at this step, the char matches the char from the word
        if(i>= rowNum || i <= -1 || j >= colNum || j <= -1 || board[i][j] != word.charAt(index))
        return false;
        
        char temp = board[i][j];
        board[i][j] = '@'; // this char can't be used more than once
        boolean result = dfs(board, i+1,j,index+1,word)||dfs(board, i-1,j,index+1,word)||dfs(board, i,j-1,index+1,word)||dfs(board, i,j+1,index+1,word);
        board[i][j] = temp; // make sure dfs doesn't change the board
        
        return result;    
    }
    
}