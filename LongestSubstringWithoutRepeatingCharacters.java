public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        
      boolean[] myExistTab = new boolean[256];
        for(int i = 0; i< 256; i++)
            myExistTab[i] = false;
            
        int front = 0;
        int end = 0;
        int maxLength = 0;
        
        
        while(end < s.length()){
            
            if(myExistTab[s.charAt(end)]){
                
                while(s.charAt(front) != s.charAt(end)  ){
                myExistTab[s.charAt(front)] = false;
                front++;
                }
                front++;
                
            } else{
                myExistTab[s.charAt(end)] = true;
                maxLength = (maxLength > end -front+1 )? maxLength: end-front +1;
            }
        
    
            end++;
        }
        
        
        
        return maxLength;
        
        
    }
}