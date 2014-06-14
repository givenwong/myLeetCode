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
            
            for(int i=0; i<currWord.length(); i++){ // String has method length()
                char[] currCharArr = currWord.toCharArray(); // String has method toCharArray()
                for(char c='a'; c<='z'; c++){
                	if(currCharArr[i] != c){
                    currCharArr[i] = c;
                    String newWord = new String(currCharArr); // String constructor to convert from char array to string
                    if(dict.contains(newWord)){ // Set has method contains()
                        wordQueue.add(newWord);
                        distanceQueue.add(currDistance+1);
                        // can't reach the same node more than once
                        dict.remove(newWord);  
                    }
                }
              }
            }
        }
        // there is no path
        return 0;
    }
}