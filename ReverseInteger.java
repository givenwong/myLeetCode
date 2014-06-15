public class ReverseInteger {
	
    public int reverse(int x) {
        
        boolean positive = true;
        String myString;
        int result =0;
        //Convert the integer to string
        if(x < 0) {
            x *=-1;
            positive = false;
        }
        // Attention!!! Easy way to convert integer to String
        myString = Integer.toString(x);
        //Reverse the string
        myString = new StringBuffer(myString).reverse().toString();
        // Convert the string to integer
        for(int i = 0; i< myString.length(); i++){
            if(result*10+myString.charAt(i) >= result)    // to prevent the overflow
            result = result*10 + myString.charAt(i)-'0';
            else System.exit(1);
        }
        
        result = (positive)? result: -1*result;
        return result;
    }
}