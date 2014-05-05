public class CountandSay {
    public String countAndSay(int n) {
        
        
        
        if(n == 1)
            return "1";
        String s = "11";    
        if(n == 2)
            return s;    
        
        int countOne  = n;
        
        while(countOne >= 3 ){
            
            int countTwo =1;
            StringBuffer buffer = new StringBuffer();
            
            for(int i =1; i <= s.length() -1; i++){
                   if(s.charAt(i) == s.charAt(i-1)){
                     countTwo++;  
                   }else{
                       
                       buffer.append(countTwo);
                       buffer.append(s.charAt(i-1));
                       countTwo = 1;
                   }  
                   
            }
            
            buffer.append(countTwo);
            buffer.append(s.charAt(s.length()-1));
            s = buffer.toString();
            
            countOne--;
        }
        
        return s;
    }
    public static void main(String[] args){
    	
    	Solution mySolution = new Solution();
    	
    	String myString = mySolution.countAndSay(60);
    	System.out.println(myString);
    }
}