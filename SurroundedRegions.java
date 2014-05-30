import java.util.*;

public class SurroundedRegions  {
    
    private ArrayList<Integer> queue = new ArrayList<Integer>();
    
    public void solve(char[][] board) {
        
        if (board.length == 0) {
            return;
        }
        if (board[0].length == 0) {
            return;
        }
        int row = board.length;
        int col = board[0].length;

        // up row
        for (int j = 0; j < col; j++) {
            if (board[0][j] == 'O') {
                bfs(board, 0, j);
            }
        }

        // bottom row
        for (int j = 0; j < col; j++) {
            if (board[row - 1][j] == 'O') {
                bfs(board, row - 1, j);
            }
        }

        // left column
        for (int i = 0; i < row; i++) {
            if (board[i][0] == 'O') {
                bfs(board, i, 0);
            }
        }

        // right column
        for (int i = 0; i < row; i++) {
            if (board[i][col - 1] == 'O') {
                bfs(board, i, col - 1);
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == 'P') {
                    board[i][j] = 'O';
                }
            }
        }
        
    }
    
    
        private void bfs(char[][] board, int i, int j) {
        
        int row = board.length;
        int col = board[0].length;
        
        queue.add(i * col + j);
        board[i][j] = 'P';
        
        while (!queue.isEmpty()) {
            int cur = queue.get(0);
            queue.remove(0);
            int x = cur / col;
            int y = cur % col;

         
            
        if (x-1 < 0 || x-1 >= row || y < 0 || y >= col || board[x-1][y] != 'O')
        ;
        else{
        queue.add((x-1) * col + y);
        board[x-1][y] = 'P';
        }
            
        if (x+1 < 0 || x+1 >= row || y < 0 || y >= col || board[x+1][y] != 'O')
        ;
        else{
        queue.add((x+1) * col + y);
        board[x+1][y] = 'P';
        }    
        
        if (x < 0 || x >= row || y-1 < 0 || y-1 >= col || board[x][y-1] != 'O')
        ;
        else{
        queue.add((x) * col + y-1);
        board[x][y-1] = 'P';
        }   
        
         if (x < 0 || x >= row || y+1 < 0 || y+1 >= col || board[x][y+1] != 'O')
        ;
        else{
        queue.add((x) * col + y+1);
        board[x][y+1] = 'P';
        } 
            
          
        
        }
        
    }
    
    
}