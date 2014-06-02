public class BestTimetoBuyandSellStockIII  {
    public int maxProfit(int[] prices) {
        
        int len = prices.length;
        if(len <= 1)return 0;
        
        int[] dp = new int[len];
        dp[0] = 0;
        int minprice = prices[0];
        for(int i = 1; i < len; i++)
        {
            minprice = (int)Math.min(prices[i-1], minprice);
            if(dp[i-1] < prices[i] - minprice)
                dp[i] = prices[i] - minprice;
            else
                dp[i] = dp[i-1];
        }
        
        int[] dp2 = new int[len];
        dp2[len-1] = 0;
        int maxprice = prices[len-1];
        for(int i = len-2; i >= 0; i--)
        {
            maxprice = (int)Math.max(prices[i+1], maxprice);
            if(dp2[i+1] < maxprice - prices[i])
                dp2[i] = maxprice - prices[i];
            else
                dp2[i] = dp2[i+1];
        }
        
        int[] profit = new int[len+1];
        profit[0] = dp2[0];
        profit[len] = dp[len-1];
        
        for(int i =1; i <= len -1;i++){
            profit[i] = dp[i-1]+dp2[i];
        }
        
        int result = 0;
        
        for(int i =0; i <= len;i++){
            result =(int)Math.max(result, profit[i]);
        }
        
        return (result >0)?result:0;
    }
}