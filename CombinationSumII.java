import java.util.*;

public class CombinationSumII {
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] candidates, int target) {
        
 Arrays.sort(candidates);
 ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
 ArrayList<Integer> temp = new ArrayList<Integer>();
 // here to dedup as candidates may have dups
 HashSet<ArrayList<Integer>> resultSet = new HashSet<ArrayList<Integer>>();
 dfs(candidates, target, 0,resultSet ,temp);
 
 for(ArrayList<Integer> current : resultSet)
    result.add(current);
 
 return result;   
    }
    
    public void dfs(int[] candidates, int target, int start, HashSet<ArrayList<Integer>> result, ArrayList<Integer> temp){
        
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
               start++;   
           }        
    }

}