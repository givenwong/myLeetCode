public class ClimbingStairs  {
	
    public int climbStairs(int n) {
     
     if(n<=0)
     return 0;
     // n is the distance so there are n+1 level
     if(n ==1)
     return 1;
     
     if(n==2)
     return 2;
     
    int[] dp = new int[n+1];
    
    // dp[0] is not used
    dp[1] =1;
    dp[2] = 2;
    
   for(int i =3; i<n+1; i++)
       dp[i] = dp[i-2]+dp[i-1];
   
      return dp[n];      
    }
}