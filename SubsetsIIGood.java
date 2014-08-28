import java.util.*;

/* How to generate the power set in case there are duplicates?
 * 
 * 1  	if the probe gets a number at its first appearance:
 *      replicate the old result set so we get two old result sets (one old result set and its replication):
 *      result, prev.
 *      add this number to every set in the old result set's replication prev
 *      now every set in result doesn't contain this number, sets in prev contain
 *      this number once. Add this number as a singleton set into prev.
 *      union prev and result to get result but keep a record of prev ("set of once") for potential use
 *      in the next round
 * 2    if the probe gets a number at its >= 2nd appearance:
 *      add this number to last round's prev to get a new prev which contains this number
 *      one more times than the old prev
 *      union result and prev to get result but keep a record of prev ("set of twice") for potential use
 *      in the next round 
 *      
 * 3    After exhaust all numbers in the array add the empty set     
 *      
 *      The major difference from no dups: add the new number only to prev otherwise will create duplicate sets
 *      Try example {1,2,2}       
 
 * */
public class SubsetsIIGood {
	
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        
    if (num == null)
	return null;
 
	Arrays.sort(num);
 
	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	
	// prev is declared out of the for loop because the result may be used in the next iteration of the for loop
	ArrayList<ArrayList<Integer>> prev = new ArrayList<ArrayList<Integer>>();
 
	for (int i = 0; i < num.length; i++) {
		//get existing sets if num[i] is in its first time
		if (i == 0 || num[i] != num[i - 1]) {
			// allocate a brand new set and copy the whole old result set of previous iteration
			prev = new ArrayList<ArrayList<Integer>>();
			for (int j = 0; j < result.size(); j++) {
				// pay attention! Construct new objects based on obejcts of result
				prev.add(new ArrayList<Integer>(result.get(j)));
			}
		}
 
		// add current number to each set of prev (prev is modified here)
		// prev may be the copy of the whole result set from last iteration which contain the current number 0 times
		// OR prev may be the prev from the last iteration which already contain the current number >= 1 times
		for (ArrayList<Integer> temp : prev) {
			temp.add(num[i]);
		}
 
		//add each single number as a set, only if current element is different from the previous one
		if (i == 0 || num[i] != num[i - 1]) {
			ArrayList<Integer> temp = new ArrayList<Integer>();
			temp.add(num[i]);
			prev.add(temp);
		}
 
		//add all set created in this iteration (union)
		for (ArrayList<Integer> temp : prev) 
			result.add(new ArrayList<Integer>(temp));
		
	}
 
	//add empty set
	result.add(new ArrayList<Integer>());
 
	return result;
	
    }
}