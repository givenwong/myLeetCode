public class DivideIntegers {
    public int divide(int dividend, int divisor) {
        
        boolean positive = true;
        int quo =0;
        
        
        if(divisor == 0)
        System.exit(1);
        
        positive = (((dividend^divisor)>>31) == 0)? true:false;
        
             
        long a = (long)Math.abs((long)dividend);
        long b = (long)Math.abs((long)divisor);
        
        
        
        while(a >= b){
            long bulk = b;
            
            for(int i= 1; bulk <= a; i<<=1, bulk<<=1 ){
                quo +=i;
                a -= bulk;
            }
          
            
        }
        
        
        return (positive)?quo:(0-quo);
        }
   
    public static void main(String[] args){
    	
    	DivideIntegers myDivideIntegers = new DivideIntegers();
    	
    	int myResult = myDivideIntegers.divide(-2147483648, 1);
    	
    	
    	System.out.println(myResult);
    	System.out.println((long)Math.abs((long)-2147483648));
    }
}
