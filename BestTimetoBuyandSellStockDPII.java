public class BestTimetoBuyandSellStockDPII {
	 public int maxProfit(int[] prices) {
	        
	        int len = prices.length;
	        if(len <= 1)
	        	return 0;
	        //dp2[i]: the optimal profit of interval i,i+1,...len-1
	        int[] dp2 = new int[len];
	        dp2[len-1] = 0;
	        //the highest price of interval i+1,...len-1
	        int maxprice = prices[len-1];
	        for(int i = len-2; i >= 0; i--){
	        	
	            maxprice = (int)Math.max(prices[i+1], maxprice);
	            if(dp2[i+1] < maxprice - prices[i])
	                dp2[i] = maxprice - prices[i];
	            else
	                dp2[i] = dp2[i+1];
	        }
	        
	        if(dp2[0] < 0)
	        	return 0;
	        else 
	        	return dp2[0];
	    }
}
