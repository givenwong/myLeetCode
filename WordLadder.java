/*Given two words (start and end), and a dictionary, 
 * find the length of shortest transformation sequence from start to end, such that:

Only one letter can be changed at a time
Each intermediate word must exist in the dictionary
For example,

Given:
start = "hit"
end = "cog"
dict = ["hot","dot","dog","lot","log"]
As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

Note:
Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.*/

import java.util.*;

public class WordLadder {
	
    public int ladderLength(String start, String end, Set<String> dict) {
        
        if (dict.size() == 0)  
            return 0; 
 
        ArrayList<String> wordQueue = new ArrayList<String>();
        ArrayList<Integer> distanceQueue = new ArrayList<Integer>();
 
        wordQueue.add(start);
        distanceQueue.add(1);
        // ArrayList object has method isEmpty()
        while(!wordQueue.isEmpty()){
            
            String currWord = wordQueue.get(0);
            wordQueue.remove(0);
            Integer currDistance = distanceQueue.get(0);
            distanceQueue.remove(0);
            //  these two queues' elements are one to one mapping
            if(currWord.equals(end))
                return currDistance;
            
            for(int i=0; i<currWord.length(); i++){
            	// String has method length()
                char[] currCharArr = currWord.toCharArray(); // String has method toCharArray()
                for(char c='a'; c<='z'; c++){
                	if(currCharArr[i] != c){
                    currCharArr[i] = c;
                    String newWord = new String(currCharArr); // String constructor to convert from char array to string
                    if(dict.contains(newWord)){ // Set has method contains()
                        wordQueue.add(newWord);
                        distanceQueue.add(currDistance+1);
                        // can't reach the same node more than once
                        // the next time newWord will have distance >= this time's newWord distance
                        // because it is the level order traversal, the distance increases 
                        dict.remove(newWord);  
                    }
                }
              
              }
            }
        }
        // there is no path, return 0 is necessary! because the target can't be reached
        return 0;
    }
}