// A recursion
// the way to best make use of * is tentative: experiment on how many opponents it can replace one by one

// Something about the String:
// String is null case is different from String's length() == 0 case and   "" is the length() ==0 case

public class RegularExpressionMatching {
	
    public boolean isMatch(String s, String p) {
        
        // the null pattern/string case
        if(s==null || p == null)
        return false;
        
        // the empty pattern case which is also the base case           
        if(p.length() == 0)
        return s.length() == p.length();
        
        // the length()==1 pattern case
        // why want to make it a corner case? Can't use the tentative approach if length() == 1
        if(p.length() == 1)
        return s.length() == 1 && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.') ;
        
        // the pattern length() >= 2  case  
        
        // p.charAt(1) != '*' case
        if(p.charAt(1) != '*') 
        return s.length() !=0 && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.') && isMatch(s.substring(1), p.substring(1));
        
        // p.charAt(1) == '*' case, otherwise the flow is returned above
            int i = 0;
            // because of s.charAt(i) can't make i == s.length()
            while(i <= s.length()-1 && (p.charAt(0) == s.charAt(i) || p.charAt(0) =='.')){
                // i = 0: the first two chars of p match no chars in s  is this allowed
            	// i = 1: the first two chars of p match 1 char in s
            	// i = 2: the first two chars of p match 2 chars in s
            	// i = s.length() -1: to see if the last char of s matches the p.substring(2) 
            	if(isMatch(s.substring(i), p.substring(2)))
                    return true;
                i++;
            }
        
            // if flow comes there i = s.length(), the first two chars of p match the whole string of s
            // and to see if an empty string matches p.substring(2) 
            // OR to see if p is exhausted 
            return isMatch(s.substring(i), p.substring(2)); 
            
            // Attention!!!!!!  s.substring(s.length()) == "" is an empty string ""

    }
}