public class MultiplyStrings{
	
    public String multiply(String num1, String num2) {
        
        StringBuffer result = new StringBuffer();
        // the product has at most num1.length()+ num2.length()
        int[] temp = new int[num1.length()+ num2.length()];
        
        String numOne = new StringBuffer(num1).reverse().toString();
        String numTwo = new StringBuffer(num2).reverse().toString();
        
        for(int i =0; i < num2.length(); i++ )
         for(int j=0; j < num1.length(); j++)
             temp[i+j] += (numOne.charAt(j)-'0')*(numTwo.charAt(i)-'0');
             
        for(int i =0; i< temp.length; i++){
            result.append(temp[i]%10);
            if( i+1 < temp.length )
                temp[i+1] += temp[i]/10; // carry to the next bit
        }                 
       result = result.reverse();
       
      while(result.charAt(0)=='0' && result.length()>1){  
            result.deleteCharAt(0);  
        }  
        return result.toString();   
    }
}