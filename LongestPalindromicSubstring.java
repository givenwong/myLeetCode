public class LongestPalindromicSubstring {
	
    public String longestPalindrome(String s) {
        
    	if(s == null || s.length()==1)
            return s;
        // should be at least 1
        int max = 1;
    
        String result = null;
        
        //for substring with even number of chars
        for(int scanner = 0; scanner <= s.length()-2; scanner++){
        	
        	int left = scanner;
        	int right = scanner +1;
        	
        while(left >=0 && right <= s.length()-1 && s.charAt(left) == s.charAt(right) ){
            if(max < right -left +1){
            max = right - left +1;
            result = s.substring(left, right+1);   
     }
            left--;
            right++;
        }
         
  }
        // for odd length substring
        if(s.length()>=3){
        for(int scanner = 1; scanner <= s.length()-2; scanner++){
        	
        	int left = scanner-1;
        	int right = scanner +1;
       
        	while(left >=0 && right <= s.length()-1 && s.charAt(left) == s.charAt(right) ){
                 if(max < right -left +1){
                	 max = right -left +1;
            result = s.substring(left, right+1);   
     }  
            left--;
            right++;
  }
}
        }
    if (max ==1) 
    	return s.substring(0,1);
    else 
    	return result;
    }
}