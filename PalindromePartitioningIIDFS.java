public class PalindromePartitioningIIDFS {
    
    int numCut =-1; // the temp version of minimum number of cuts
    int minNumCut = Integer.MAX_VALUE;
    
    public int minCut(String s) {
        
      dfs(s,0);
      return minNumCut;    
    
    }
    
    boolean isPalindrome(String s, int front, int end){
    
        if(front > end)
        return false;
        
        while(front < end){
            if(s.charAt(front) != s.charAt(end))
            return false;
            front++;
            end--;
        }
        
        return true;
    }
    
    void dfs(String s, int start){
         
         if(start >= s.length()){
             minNumCut = (minNumCut < numCut)?minNumCut:numCut;
             return;
         } 
         
         
         for(int i = s.length()-1; i >= start; i--){
             
             if( (numCut < minNumCut) && isPalindrome(s,start,i)){
                 numCut++;
                 dfs(s,i+1);
                 numCut--;
             }
         }
         
    }


}