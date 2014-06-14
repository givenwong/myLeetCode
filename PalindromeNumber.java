public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        
        if(x==0)
        return true;
      
        int numDigits = 0;
        long xx = x;
        
        if(xx<0)
        return false; 
       
        while(xx >= Math.pow(10, numDigits))
            numDigits++;
        
        if(numDigits == 1)
        return true;
        
        int index = numDigits;
        while(index >=1){
        	  // to get the front number, each time get the number starting from the 2nd bit by subtracting the 1st bit off
              long front = xx -(xx/(long)Math.pow(10,index))*(long)Math.pow(10,index);
              front = front/(long)Math.pow(10,index-1);
              // 
              long end = xx -(xx/(long)Math.pow(10,numDigits - index+ 1))*(long)Math.pow(10,numDigits - index +1);
              end = end/(long)Math.pow(10,numDigits -index);
              
              if(front != end)
              return false;
              
              index--;
        }
        return true;  
    }
}