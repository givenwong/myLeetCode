public class PermutationSequence {
    
   String getPermutation(int n, int k) {
		
		        int[] nf={1,2,6,24,120,720,5040,40320,362880}; 
		        StringBuffer res = new StringBuffer();
		        for (int i=1;i<=n;i++)
		        	res.append((char)(i+'0'));// the first perm
		        
		        k--; // array index starts from zero not one
		        
		        for (int i=1;i<=n-1;i++){
		        	
		            int m = k%nf[n-i-1]; // index within the subtree
		            int s = k/nf[n-i-1]; // index of the subtree
		            
		            
		            
		         
		                   // adjust from the 2nd subtree and don't adjust for the 1st subtree
		                   // get the root nodes first
		                	for (int j=i-1+s; j>i-1;j--){
		                        char tmp = res.charAt(j);
		                        res.setCharAt(j, res.charAt(j-1));
		                        res.setCharAt(j-1, tmp);
		                    }
		                    if (m==0){return res.toString();} // after adjustment if it is the root node return it 
		                
		                k=m;
		                       
		        }
		        
		        return res.toString(); // if n =1 no for loop return directly
		    }
	
}