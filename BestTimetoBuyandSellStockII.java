public class BestTimetoBuyandSellStockII  {
    
    public int maxProfit(int[] prices) {
     
      int sum =0;
      for(int i =0; i <= prices.length-2; i++){
          if(prices[i+1] > prices[i])
              sum += prices[i+1] -prices[i];
      }
      
      return sum;
         
    }
}