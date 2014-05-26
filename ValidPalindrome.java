public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        
        char[] myCharArray = s.trim().toCharArray();
    
      int front =0;
      int end = myCharArray.length-1;
      
      while(front < end){
          
          if(!isAlphNum(myCharArray[front])){
          front++;
          continue;      
          }
          if(!isAlphNum(myCharArray[end])){
          end--;
          continue;
          }
          
          if(Character.toLowerCase(myCharArray[end]) != Character.toLowerCase(myCharArray[front]))
          return false;
           
          front++;
          end--;
          
      }
      
      return true;

    }
    
    
    boolean isAlphNum(char thisChar){
        if(thisChar>= 'a' && thisChar<= 'z' || thisChar>= 'A' && thisChar<= 'Z' || thisChar>= '0' && thisChar<= '9' )
        return true;
        return false;
    }
    
    
}