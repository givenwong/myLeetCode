public class AddBinary  {
    public String addBinary(String a, String b) {
        
        if(a == null || b == null)
        System.exit(1);
        
        StringBuffer aBuffer = new StringBuffer(a).reverse();
        StringBuffer bBuffer = new StringBuffer(b).reverse();
        
        if(a.length() < b.length()){
            for(int i = a.length(); i< b.length();i++)
                aBuffer.append('0');
        }else{
             for(int i = b.length(); i< a.length();i++)
                bBuffer.append('0');
        }
        
        bBuffer.append('0');	// in case there is a carry generated from the most significant bit (MSB)
        aBuffer.append('0');    // the result would have one more bit than the longer number
        
        aBuffer = aBuffer.reverse();
        bBuffer = bBuffer.reverse();
        StringBuffer resultBuffer = new StringBuffer();
        
        char carry ='0';
        char[] temp = null;
        for(int i= (int)Math.max(a.length(), b.length()); i >=0; i--){
            temp = addBit(aBuffer.charAt(i), bBuffer.charAt(i), carry);
            resultBuffer.append(temp[0]);
            carry = temp[1];
        }
        
        resultBuffer = resultBuffer.reverse();
        
        if(resultBuffer.charAt(0) == '0')
        	resultBuffer.deleteCharAt(0);
        
        return resultBuffer.toString();
    }
    
    public char[] addBit(char a, char b, char carry){
         
           char[] bitResult = new char[2];   // char[0]: the bitResult   char[1]: carry
           
           int aa = a -'0';
           int bb = b -'0';
           int carrycarry = carry -'0';
           
           bitResult[0] =(char)((aa+bb+carrycarry)%2+'0');  // always remember the casting
           bitResult[1] =(char)((aa+bb+carrycarry)/2+'0'); 
           
           return bitResult;
    }
}