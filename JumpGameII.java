public class JumpGameII {
    
    public int jump(int[] A) {
        
        
        int i =0; // current position
        int numJumps = 0;
       
        
        
        if(A == null)
        System.exit(1);
        
        if(A.length == 0)
        return 0;
        
        if(A.length == 1)
        return 0;
        
        int range =A[i]+i;
        
        while(i<A.length){
            
           
            
           
            
            if(range >= A.length-1)
                return numJumps+1;
            
            int temp =A[i]+i;    
            for(int j =i+1; j <= range && j <= A.length-1; j++ ){
                
                  if(temp < A[j] + j){
                    temp = A[j] + j;
                    i=j;     
                  }
                 
            }
            numJumps++;
            range = temp;
            
            
            
            
        }
        
        
        return numJumps ;
    }

public static void main(String[] args){
	JumpGameII mySolution = new JumpGameII();
	int[] A = {1,2,3,4,5};
	int myResult = mySolution.jump(A);
	
	System.out.println(myResult);
	
	
	
}

}
