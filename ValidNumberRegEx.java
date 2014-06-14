public class ValidNumberRegEx  {
    public boolean isNumber(String s) {
       
       // string's isEmpty() method
       // see if string matches a regular expression String.matches(regular expression's string)	
       if(s.trim().isEmpty()){  
            return false;  
        } 
        
       // []: one of it
       // ?: zero or one
       // +: one or more
       // *: zero or more
        String regex = "[-+]?(\\d+\\.?\\d*|\\.\\d+)(e[-+]?\\d+)?";  
        if(s.trim().matches(regex)) 
            return true;  
        else  
            return false;  
    }
}