public class ReverseWordsinaString  {
	
    public String reverseWords(String s) {
        
        String result = "";
     
        if(s.length() == 0)
        return result;
        
        String sAfterTrim = s.trim();
        
        StringBuffer buffer = new StringBuffer(sAfterTrim);
        buffer = buffer.reverse();
        String reversedOne = buffer.toString();
        String[] reversedOneSplited = reversedOne.split(" ");
        
        for(String temp : reversedOneSplited){
            String tempTwo = temp.trim();
    
            StringBuffer word = new StringBuffer(tempTwo);
            word = word.reverse();
                
            if(word.length() != 0)
            result = result + " " +word; 
   
        }
        
        return result.trim();   
    }
} 