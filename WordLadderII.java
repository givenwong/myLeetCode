import java.util.*;

public class WordLadderII {
	
    public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
    	// this is the result to return
        ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
        if (start == null || end == null) 
        	return res;
        // saves each of the path from start to end
        ArrayList<String> tmparray = new ArrayList<String>();
        // this is not a dfs method so it is not a base case but a corner case
        if (start.equals(end)) {
        	tmparray.add(start);
        	tmparray.add(end);
        	res.add(tmparray);
        	return res;
        }
        // for the current string and all the strings RIGHT prior to it (a list of its adjacent strings)
        // and this map is only for the strings in the dictionary except the start and the end
        // map contains no duplicate keys by definition and by the way adding elements to map
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        map.put(end, new ArrayList<String>()); // HashMap has method put(key, value) and get(key)
        map.put(start, new ArrayList<String>());
        for (String s : dict) 
        	map.put(s, new ArrayList<String>());
        // all elements in queue are in the dictionary except for the start and end
        Queue<String> queue = new LinkedList<String>();
        queue.offer(start); // Queue has method offer(),poll() and peek();
         
        // currentlevel is for all the strings in this level
        // all elements in currentlevel are in the dictionary except for the start and end
        // why want an extra currentlevel on top of the queue? to process by level:
        // one for current leven and one for next level
        // this tech can be used for level traveled binary tree and there is no more need for the counter
        ArrayList<String> currentlevel = new ArrayList<String>(); 
        while (!queue.isEmpty()) {
            // the queue only contains nodes in one level (a level is identified by the distance to start)
        	int level = queue.size();
        	// ArrayList object has methond clear()
        	currentlevel.clear();
            // Queue -> ArrayList
        	for (int i = 0; i < level; i++) {
        		String top = queue.poll();
        		if (dict.contains(top)) 
        			dict.remove(top); // this guarantees there is no duplicates 
        		currentlevel.add(top);
        	}
        	// there are two cases we want to explore:
        	// 1 the next level string is in the dictionary
        	// 2 the next level string is the end (allow end not to be in the dictionary)
        	// for case 2, can't jump from start to end directly without touching the dictionary
        	for (String curs : currentlevel) {
        		for (int i = 0; i < curs.length(); ++i) {
        			for (char j = 'a'; j <= 'z'; ++j) {
        				char[] tmpchar = curs.toCharArray();
        				tmpchar[i] = j;
        				String tmps = new String(tmpchar);
        				// can't jump from start to end directly
        				if (!curs.equals(start) && tmps.equals(end)) {
        					map.get(end).add(curs);
        					queue.offer(end); // queue is for the next level and currentlevel is for this level
        				}
        				else if (!curs.equals(tmps) && dict.contains(tmps)) {
        					if (!queue.contains(tmps)) 
        						queue.offer(tmps);
        					map.get(tmps).add(curs); // a node may have more than one fathers in previous level
        				}
        			}
        		}
        	}
        	// there is no need to try the next level and queue contains all the end in this level
        	// otherwise it is no longer the shortest path
        	if (queue.contains(end)) 
        		break;
        }
        
        // the BFS is for building the HashMap which is for the DFS
        
        
        // tmparray adds its first element, in the dfs tmparray is built reversely
        // the dfs only adds from the 2nd last string so the first last one has to
        // be added here 
        tmparray.add(end);
        buildpath(start, end, map, tmparray, res);
        return res;
    }

    // the major function generate all possible (adjacencies) and the dfs function here figure out the path
	public void buildpath(String start, String end, HashMap<String, ArrayList<String>> map, ArrayList<String> tmparray, ArrayList<ArrayList<String>> res) {
		ArrayList<String> pre = map.get(end);
 		if (end.equals(start)) {
 			ArrayList<String> tmparray2 = new ArrayList<String>(tmparray);
 			// ArrayList 's system method
 			Collections.reverse(tmparray2);
 			res.add(tmparray2);
 			return;
 		}
 		for (String s: pre) {
 			tmparray.add(s); 
 			buildpath(start, s, map, tmparray, res);
 			tmparray.remove(tmparray.size() - 1); // make sure tmparray is not modified
 		}	
	}
}