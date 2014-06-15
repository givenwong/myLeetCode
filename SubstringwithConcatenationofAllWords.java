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
        	
        // i is the starting index of the whole string each time
        for(int i=0; i<= S.length()-windowSize; i++){
              // assume it is correct and try to prove it is wrong
        	  boolean flag = true;
        	  // this is the local copy of L's map
        	  HashMap<String,Integer> myMapTemp = new HashMap<String,Integer>(myMap);
            // j is the starting index of each probe sub - window   
            for(int j =0; j<= windowSize-unitLength;j += unitLength ){
            // null: never gets initialized; 0: from positive number to zero	
            if(	myMapTemp.get(S.substring(i+j, i+j+unitLength)) == null || myMapTemp.get(S.substring(i+j, i+j+unitLength)).intValue() <= 0){
            flag = false;
            break;
            } else{
            	myMapTemp.put(S.substring(i+j, i+j+unitLength), myMapTemp.get(S.substring(i+j, i+j+unitLength)).intValue()-1);
            }
            
           }
           // if the inner for loop is finished: all content in the winowSize is in L and as windowSize == L
           // so L is also exhausted 
            
            if(flag)
            	result.add(i);
            
        }
        
        return result;
        
    }
}