public class PlusOne {
    public int[] plusOne(int[] digits) {
        
        int[] result = new int[digits.length];
        int carry = 1;
        for(int i = digits.length-1; i >= 0; i--){
            result[i] = (digits[i]+ carry)%10;
            carry = (digits[i]+ carry)/10;
        }
        
        if(carry >0){
        int[] newResult = new int[digits.length+1];
        
            newResult[0]= carry;
            
            for(int i=1; i<digits.length; i++)
            newResult[i] = result[i-1];
        
            return newResult;
        }
        
        
        return result;
    }
}