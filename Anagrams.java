/*
 * Given an array of strings, return all groups of strings that are anagrams.

Note: All inputs will be in lower-case.
*/

import java.util.*;

public class Anagrams  {    
	
    public ArrayList<String> anagrams(String[] strs) {
    	
        HashMap<String, Integer> myHashMap = new HashMap<String,Integer>();
        ArrayList<String> result = new ArrayList<String>();
        
        for(String temp : strs){
            char[] chars = temp.toCharArray();
            Arrays.sort(chars); // sort char array to find anagrams
            String sortedTemp = new String(chars);// construct String from char array
            
            if(myHashMap.get(sortedTemp) == null)
                myHashMap.put(sortedTemp, 1);
            else        
                myHashMap.put(sortedTemp, myHashMap.get(sortedTemp)+1);   
        }
         
         for(String temp : strs){
        	 
            char[] chars = temp.toCharArray();
            Arrays.sort(chars);
            String sortedTemp = new String(chars);
            
            if(myHashMap.get(sortedTemp) > 1)
                result.add(temp);   
        }     
        return result;   
    }
}