import java.util.*;


public class CombinationSum {
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        
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
               dfs(candidates, target -candidates[start] , start, result, temp);
               temp.remove(temp.size()-1);
               start++;
               
               
           }
        
    }
    
    
    public static void main(String[] args){
    	
    	CombinationSum mySolution = new CombinationSum();
    	ArrayList<ArrayList<Integer>> myResult;
    	
    	int[] candidates = {1};
        myResult = mySolution.combinationSum(candidates, 1);
    }
}