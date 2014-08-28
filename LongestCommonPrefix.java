public class LongestCommonPrefix  {
    public String longestCommonPrefix(String[] strs) {
        
        if(strs == null )
            return null;
        if(strs.length == 0)
            return "";    
        if(strs.length == 1)
            return strs[0]; 
        
        String result;
        String shortest = strs[0];
        // get the shortest string
        for(int i = 1 ; i <= strs.length-1; i++) {
              if(strs[i] == null) return null;
              if(shortest.length() > strs[i].length())
                shortest = strs[i];
        }
        
        for(int i = 0; i <= shortest.length()-1; i++){
            for(int j = 0; j <= strs.length-1; j++){
                if(shortest.charAt(i) != strs[j].charAt(i)){
                	// substring is a method of both String and StringBuffer
                    result = shortest.substring(0,i);
                    return result; // if there is no common prefix, null is returned here as shortest.substring(0,0) is null
                }   
            }
        }
        // if reach here, the shortest is the longest common prefix and the result is never initialized 
        return shortest;
    }
}