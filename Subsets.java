import java.util.*;

// each time replicate the sets and add the new element into the replica (and a singleton set with only the 
// new element)     at last add the empty set
//
public class Subsets {
    
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        
    if (S == null)
    	return null;
    	
    // asks for elements in ascending order in all subsets
	Arrays.sort(S);
 
	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
 
	for (int i = 0; i < S.length; i++) {
		// temp is for the new sets 
		ArrayList<ArrayList<Integer>> temp = new ArrayList<ArrayList<Integer>>();
 
		// get sets that are already in result generated from the previous round
		// pay attention that construct a new object of ArrayList<Integer> temp !!
		for (ArrayList<Integer> a : result) {
			temp.add(new ArrayList<Integer>(a));
		}
 
		//add S[i] to the existing sets
		for (ArrayList<Integer> a : temp) {
			a.add(S[i]);
		}
 
		//add S[i] only as a set
		ArrayList<Integer> single = new ArrayList<Integer>();
		single.add(S[i]);
		temp.add(single);
		
        // union two sets:
		for(ArrayList<Integer> a: temp)
			result.add(a);
	}
 
	//add empty set
	result.add(new ArrayList<Integer>());
 
	return result;
	
    }
  
}