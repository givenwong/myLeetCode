public class UniquePathsRecursion {
    int result =0;
    public int uniquePaths(int m, int n) {
        
        if(m<1&&n<1)
        return result;
        
        if(m==1&&n==1)
        return 1;
        
        if(m>=1&& n>=1)
            dfs(m,n); 
           
            return result;  
    }
    
    public void dfs(int mRemaining, int nRemaining){
    	// the base case
        if(mRemaining ==1 && nRemaining ==1){
            result++;
            return;
        }
        
        // the following are the 3 non base cases
        
        if(mRemaining ==1 && nRemaining > 1){
            dfs(1,nRemaining-1);
            return;
        }
        if(nRemaining ==1 && mRemaining > 1){
            dfs(mRemaining-1,1);
            return;
        } 
      //try vertically
       if(mRemaining >1 && nRemaining > 1){
            dfs(mRemaining-1,nRemaining);
        }
      // try horizontally
       if(mRemaining >1 && nRemaining > 1){
            dfs(mRemaining,nRemaining-1);
        }
    }

}