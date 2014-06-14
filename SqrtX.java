public class SqrtX  {
    public int sqrt(int x) {
        
        if(x < 0)
        System.exit(1);
        
        if(x ==0)
        return 0;
        
        if (x==1) {return 1;}
        
        long low = 0;
        long high = x;
        
        // can not make high - low == 1 or even smaller  if so mid  = low
        // if low* low <= x     low = mid = low (and high is as before) and this case high - low == 1   infinity loop
        // if low* low > x      high = low (and low is as before) and there will be no next round so no matter return
        // 						low or high, it is a wrong answer
        while (high-low >1){
        	
        	long mid = (high+low)/2; // this is integer divide if high - low <= 1 then may cause infinity loop
        	
         if (mid*mid<=x)
        	 low = mid;
         else 
        	 high = mid;
        }
        
        // why return low? want to return the largest number whose square is no greater than x
        return (int)low;  
    }
}