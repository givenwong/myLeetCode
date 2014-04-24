public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        
        if(x==0)
        return true;
        
        
        
        boolean positive = true;
        int numDigits = 1;
        long xx = x;
        
        if(xx<0){
           xx = xx*(-1);
           positive = false;
        }
        
        
        while(xx >= Math.pow(10, numDigits-1)){
            numDigits++;
        }
        
        numDigits--;
        
        if(numDigits == 1)
        return true;
        
        int index = numDigits;
        
        
        while(index >=1)
        {     
              long front = xx -(xx/(long)Math.pow(10,index))*(long)Math.pow(10,index);
              front = front/(long)Math.pow(10,index-1);
              long end = xx -(xx/(long)Math.pow(10,numDigits - index+ 1))*(long)Math.pow(10,numDigits - index +1);
              end = end/(long)Math.pow(10,numDigits -index);
              
              if(front != end)
              return false;
              
              index--;
              
        }
        
        return true;
        
    }
    
    public static void main(String[] args){
    	
    	boolean myResult = new PalindromeNumber().isPalindrome(-2147483648);
    	System.out.println(myResult);
    	
    }
}