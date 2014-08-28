// the rolling hash approach to reduce the complexity
// complexity of rolling hash is linear
public class ImplementstrStr {
	
   public String strStr(String haystack, String needle) {
	// pay attention to all the corner cases   
    if(haystack==null || needle==null) 
    	return null;
    
    if(haystack.length()==0){
        return needle.length()==0?"":null;
    }
    
    if(needle.length()==0) 
    	return haystack;
    if(haystack.length()<needle.length()) 
    	return null;

    int base = 29; // some prime number
    long patternHash = 0;
    long tempBase = 1;
    // the hash code is based on the ASCII code of each char
    for(int i=needle.length()-1; i>=0; i--){
     patternHash += (int)needle.charAt(i)*tempBase;
     tempBase *= base;
    }
    
    // process the first rolling window
    long hayHash = 0;
    tempBase = 1;
    for(int i=needle.length()-1; i>=0; i--){
     hayHash += (int)haystack.charAt(i)*tempBase;
     tempBase *= base;
    }
    //why? tempBase get multiplied by base one more time
    tempBase /= base;

    if(hayHash == patternHash){
     return haystack;
    }
    // start from the 2nd rolling window
    for(int i=needle.length(); i<haystack.length(); i++){
     hayHash = (hayHash - (int)haystack.charAt(i-needle.length())*tempBase)*base+(int)haystack.charAt(i);
        if(hayHash == patternHash){
      return haystack.substring(i-needle.length()+1);
     }
    }
    
    return null;
   } 
}