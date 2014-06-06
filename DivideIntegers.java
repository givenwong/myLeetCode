public class DivideIntegers {
    public int divide(int dividend, int divisor) {
        
        boolean positive = true;
        int quo =0;
        
        if(divisor == 0)
        System.exit(1);
        // to decide if the two numbers have the same sign
        positive = (((dividend^divisor)>>31) == 0)? true:false;
        // intermediate number may exceed Integer.MAX_VALUE so use long here
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
}
