public class StringToInteger {
    public int atoi(String str) {
        
        //null string or empty string
        if (str == null || str.length() == 0)
        return 0;
        
        // handle the leading empty spaces in input
        String myString = str.trim();
        if (myString.length()==0)
        return 0;
        
        StringBuffer myStringBuffer = new StringBuffer(myString);
        
      
        boolean positive = true;
        int result = 0;
        
        //handle the signs
        if(myStringBuffer.charAt(0) == '+')
        myStringBuffer.deleteCharAt(0);
        else if (myStringBuffer.charAt(0) == '-'){
            positive = false;
            myStringBuffer.deleteCharAt(0);
        }
                
      
       // check if the first char is valid numeric char
       if(myStringBuffer.charAt(0) >'9' || myStringBuffer.charAt(0) <'0')
        return 0;
       
       for(int i = 0; i < myStringBuffer.length(); i++){
          if(myStringBuffer.charAt(i) <='9' && myStringBuffer.charAt(i) >='0')
              {if ( result  > (double)(2147483647- myStringBuffer.charAt(i)+'0')/10 && positive ){ return  2147483647; }
              else if(result  > (double)(2147483647- myStringBuffer.charAt(i)+'0')/10 && !positive ){return  -2147483648;} 
              else
        	   result = result*10 + myStringBuffer.charAt(i)-'0';}
          else
              break;
       }
      
         
        result = (positive)? result: -1*result;
        
        return result;
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }
    
    
    public static void main(String[] args){
     
    	StringToInteger myStringToInteger = new StringToInteger();
    	long myresult = myStringToInteger.atoi("    10522545459");
    	System.out.println(myresult);
    }
}
