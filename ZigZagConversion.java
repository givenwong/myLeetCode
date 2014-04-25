public class ZigZagConversion {
    public String convert(String s, int nRows) {
        
        if (s == null)
        return null;
        
        
        char[][] input = new char[nRows][s.length()/2+1];
        StringBuffer output = new StringBuffer();
        
        
        if (nRows == 1)
        output = new StringBuffer(s);
        else{
        
        int j = 0;
        int index = 0; 
        
            while(index < s.length()){
            //south
            for(int i = 0; i <= nRows -1 && index < s.length(); i++){
                input[i][j] = s.charAt(index);
                index++;
            }
           
            //northeast
                if(nRows > 2) {
               for(int i = nRows -2; i>=1 && index < s.length(); i--){
                   j++;
                   input[i][j] = s.charAt(index);
                   index++;
               }
              
                }
                
                j++;
            }
        
        for(int i = 0; i<= nRows -1; i++)
            for(int t = 0; t <= input[i].length-1; t++)
                if(input[i][t] != '\0')
                output.append(input[i][t]);
        
        
        
        }
            
        
        
        
        
        
     return output.toString();   
        
        
        
        
        
    }
    
    
    public static void main(String[] args){
    	
    	Solution mySolution = new Solution();
    	
    	String result = mySolution.convert("ABC", 2);
    	System.out.println(result);
    	
    	
    }
}