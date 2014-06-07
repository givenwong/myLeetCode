import java.util.*;

public class WordLadder {
    public int ladderLength(String start, String end, Set<String> dict) {
        
        if (dict.size() == 0)  
            return 0; 
 
        ArrayList<String> wordQueue = new ArrayList<String>();
        ArrayList<Integer> distanceQueue = new ArrayList<Integer>();
 
        wordQueue.add(start);
        distanceQueue.add(1);
        while(!wordQueue.isEmpty()){
            
            String currWord = wordQueue.get(0);
            wordQueue.remove(0);
            Integer currDistance = distanceQueue.get(0);
            distanceQueue.remove(0);
            //  these two queues' elements are one to one mapping
            if(currWord.equals(end)){
                return currDistance;
            }
 
            for(int i=0; i<currWord.length(); i++){
                char[] currCharArr = currWord.toCharArray();
                for(char c='a'; c<='z'; c++){
                    currCharArr[i] = c;
                    String newWord = new String(currCharArr);
                    if(dict.contains(newWord)){
                        wordQueue.add(newWord);
                        distanceQueue.add(currDistance+1);
                        dict.remove(newWord);  // can't reach the same node more than once
                    }
                }
            }
        }
        // there is no path
        return 0;
    }
}