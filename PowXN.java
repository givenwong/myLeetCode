public class PowXN {
	
	    

		   public double pow(double x, int n) {
			if (n == 0)
				return 1;
		    
		    boolean flag = true;
		    
		    if(n <0){
		    flag = false;
		    n = 0-n;
		    }
		    
		    double v = pow(x,n/2);
		    
		    if(flag){
			if (n % 2 == 0) {
				return v * v;
			} else {
				return v * v * x;
			}}else{	if (n % 2 == 0) {
				return 1/(v * v);
			} else {
				return 1/(v * v * x);
			}
			    
			}
		}
		 


		
}