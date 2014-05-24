public class ValidNumberIteration {
    
    public boolean isNumber(String s) {
        
         if (s==null ){
             return false;
         } 
         
         // trim off head and tail spaces which don't affect result depend on question
         s=s.trim();
         if(s.length()==0){
             return false;
         } 
         
        boolean hasNum=false; // this is the result
        
        boolean canSign=true; // there are at most two signs
        boolean canDot=true;  // there is at most one dot
        
        boolean canE=false;   // there are at most two es
        boolean hasE=false;
        
        // the treatments of sign and e should be the same but only set hasE for e cuz it works for both sign and E (the 2nd sing must follow a E)
        
        int i=0;
        while(i<s.length()){
            char c=s.charAt(i++);
            
            if (c==' '){
               return false;
            }
            
            if (c=='+' ||c=='-'){
                if (!canSign){
                    return false;
                }
                canSign=false; // there is already a sign in this part
                continue;
            }
            
            if (c=='.'){
                if (!canDot){
                    return false;
                }
                canDot=false;   // already a dot
                canSign=false;   // no sign in the decimal part
                continue; 
            }
            
            if (c=='e'){
                
                if (!canE||hasE){
                    return false;    // can't have two es 
                }
                
                canE=false;   //
                hasE=true;
                hasNum=false;   //expecting nums
                canDot=false;   // no dot after e
                canSign=true;
                
                continue;
            }
            
            
            if (c>='0' && c<='9'){
                hasNum=true;
                
                if (!hasE){ // can't have more than one e!
                    canE=true;
                }
                canSign=false;
            }
            else{
                return false;
            }
            
            
        }
        
        return hasNum;
    }
    
    public static void main(String[] args){
    	ValidNumberIteration  myValidNumberIteration = new ValidNumberIteration();
    	boolean myResult = myValidNumberIteration.isNumber("2e10");
    	System.out.println(myResult);
    	
    }
}