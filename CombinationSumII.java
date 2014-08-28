import java.util.*;

public class CombinationSumII {
	
	public class Solution {
		  
		
	    public ArrayList<ArrayList<Integer>> combinationSum2(int[] candidates, int target) {
	        
	 Arrays.sort(candidates);
	 ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	 ArrayList<Integer> temp = new ArrayList<Integer>();
	 dfs(candidates, target, 0,result ,temp);
	 
	 return result;   
	    }
	    
	    public void dfs(int[] candidates, int target, int start, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> temp){
	        
	           if(target < 0)
	            return;
	            
	           if(target == 0){
	               result.add(new ArrayList<Integer>(temp));
	               return;
	           }
	           
	           while(start <= candidates.length -1 && target - candidates[start] >= 0){
	               
	             
	               temp.add(candidates[start]);
	               dfs(candidates, target -candidates[start] , start + 1, result, temp);
	               temp.remove(temp.size()-1);
	               
	               // in the case that there are dups in the candidates:
	               // how to avoid the dups? avoid trying the same number at the same level/depth
	               // the same number can be used in the next level/depth
	               
	               // tentatively move to the next candidate and try it in the current depth
	               start++;
	               // if it is a dup, skip it till the new content
	               while(start <= candidates.length -1 && candidates[start] == candidates[start -1])
	               start++;
	                   
	           }        
	    }

	}
}