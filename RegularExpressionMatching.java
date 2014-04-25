public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        
        // the null pattern/string case
        if(s==null || p == null)
        return false;
        
        // the empty patther case
        if(p.length() == 0)
        return s.length() == p.length();
        
        // the length()==1 pattern case
        if(p.length() == 1)
        return s.length() == 1 && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.') ;
        
        // the length() >=2 patther case
        
        if(p.charAt(1) != '*') // p.charAt(1) != '*' case
        return s.length() !=0 && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.')&& isMatch(s.substring(1), p.substring(1));
        
         // p.charAt(1) == '*' case
            int i = 0;
            while(i<= s.length()-1 && (p.charAt(0) == s.charAt(i) || p.charAt(0) =='.')){
                if(isMatch(s.substring(i), p.substring(2)))
                    return true;
                i++;
            }
            
            return isMatch(s.substring(i), p.substring(2)); 
        
        
        
        
        
        
        
        
        
        
        
    }
}