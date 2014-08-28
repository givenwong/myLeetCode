public class LongestPalindromicSubstringDP {

	public String longestPalindrome(String s) {
        
        if(s == null || s.length() == 1)
            return s;
   
        boolean[][] dp = new boolean[s.length()][s.length()];
        int front=0;
        int end=0;
        int max = 1;
 
        //base case I: start from length == 1
        for (int i = 0 ; i <= s.length()-1; i++){
            dp[i][i] = true;
            max = 1;
            front = i;
            end = i;
        }
        //base case II: start from length == 2
         for (int i = 0 ; i <= s.length()-2; i++){
            if(s.charAt(i) == s.charAt(i+1)){
            dp[i][i+1] = true;
            max = 2;
            front = i;
            end = i+1;
            }
            else
            dp[i][i+1] = false;
        }
        
        if(s.length()>= 3){
        // gap increases	
        for (int gap  = 2; gap <= s.length()-1; gap++){
            for (int i = 0; i <= s.length() -1 - gap; i++){
                if(s.charAt(i) == s.charAt(i+gap) && dp[i+1][i+gap-1] == true){
                    // from dp[i+1][i+gap-1] to dp[i][i+gap]
                	dp[i][i+gap] = true;
                    if(max < gap+1){
                    max = gap +1;
                    front = i;
                    end = i+gap;
                    }
                }
            }
        }
    }
        return s.substring(front, end+1);   
    }
}