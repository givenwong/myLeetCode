public class BestTimetoBuyandSellStock {
    public int maxProfit(int[] prices) {
        
        if(prices == null || prices.length == 0 ||prices.length == 1)
        return 0;
        
        int[] diff = new int[prices.length-1];
        for(int i =0; i < prices.length-1; i++)
            diff[i] = prices[i+1] - prices[i];
        
        int max = Integer.MIN_VALUE;
        int sum =0;
        int scanner = 0;
        
        while(scanner < prices.length-1 ){
            sum += diff[scanner];
            max = (max> sum)?max:sum;
            
            if(sum < 0)
            sum =0;
            
            scanner++;
        }
        return (max>0)?max:0;
    }
}