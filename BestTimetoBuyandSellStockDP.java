public class BestTimetoBuyandSellStockDP  {
	
    public int maxProfit(int[] prices)  {
        
        int len = prices.length;
        if(len <= 1)
        	return 0;
        // dp[i]: the largest profit of interval 0,1,2...i
        int[] dp = new int[len];
        dp[0] = 0;
        // the min price of interval 0,1,2...i-1
        int minprice = prices[0];
        
        for(int i = 1; i < len; i++){
        	
            minprice = (int)Math.min(prices[i-1], minprice);
            if(dp[i-1] < prices[i] - minprice)
                dp[i] = prices[i] - minprice;
            else
                dp[i] = dp[i-1];
        }
        if(dp[len-1] < 0)
        	return 0;
        else 
        	return dp[len-1];
    }
}