public class UniquePathsRecursion {
    
    int result =0;
    
    public int uniquePaths(int m, int n) {
        
        if(m<1&&n<1)
        return result;
        
        if(m==1&&n==1)
        return 1;
        
        if(m>=1&& n>=1)
            dfs(m-1,n-1);
            
            
            return result;
        
        
        
    }
    
    
    public void dfs(int mRemaining, int nRemaining){
        
        if(mRemaining ==0 && nRemaining ==0){
            result++;
            return;
        }
        
           if(mRemaining ==0 && nRemaining > 0){
            dfs(0,nRemaining-1);
            return;
        }
   
              if(nRemaining ==0 && mRemaining > 0){
            dfs(mRemaining-1,0);
            return;
        } 
        
        //try vertically
              if(mRemaining >0 && nRemaining > 0){
            dfs(mRemaining-1,nRemaining);
        }
      // try horizontally
                   if(mRemaining >0 && nRemaining > 0){
            dfs(mRemaining,nRemaining-1);
        }
   
    }
 
    public static void main(String[] args){
    	
    	UniquePathsRecursion mySolution = new UniquePathsRecursion();
    	int myResult = mySolution.uniquePaths(10, 8);
    	System.out.println(myResult);
    }
}