import java.util.*;


public class SubstringwithConcatenationofAllWords {
    public ArrayList<Integer> findSubstring(String S, String[] L) {
        
        if(L == null)
        System.exit(1);
    
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        if(S == null)
        return result;
        
        if(L.length == 0)
        return result;
        
        int unitLength = L[0].length();        
        int windowSize = unitLength*L.length; 
        HashMap<String,Integer> myMap = new HashMap<String,Integer>();
        for(String temp: L){
        	if(myMap.get(temp) == null)
        		myMap.put(temp, 1);
        	else
        		myMap.put(temp, myMap.get(temp)+1);
        }
        	
        
        for(int i=0; i<= S.length()-windowSize; i++){
              
        	  boolean flag = true;
        	  HashMap<String,Integer> myMapTemp = new HashMap<String,Integer>(myMap);
               
            for(int j =0; j<= windowSize-unitLength;j += unitLength ){
            	
            if(	myMapTemp.get(S.substring(i+j, i+j+unitLength)) == null || myMapTemp.get(S.substring(i+j, i+j+unitLength)).intValue() <= 0){
            flag = false;
            break;
            } else{
            	myMapTemp.put(S.substring(i+j, i+j+unitLength), myMapTemp.get(S.substring(i+j, i+j+unitLength)).intValue()-1);
            }
            
           }
             
            if(flag)
            	result.add(i);
            
        }
        
        
        
        return result;
        
        
    }
    
    public static void main(String[] args){
    	
    	SubstringwithConcatenationofAllWords mySubstringwithConcatenationofAllWords = new SubstringwithConcatenationofAllWords();
    	String[] L = {"a","b"};
    	ArrayList<Integer> myResult = mySubstringwithConcatenationofAllWords.findSubstring("aaa", L);
    	System.out.println(myResult);
    }
    
}