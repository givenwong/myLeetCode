import java.util.*;

public class Combinations  {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        dfs(n,0,k,result, temp );
        return result;
        
        
    }
    
    public void dfs(int n, int lastTime, int k, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> temp ){
        
        //lastTime is for the range of selection, n is also for the range of selection
        // k is the remaining number of numbers
        
        if(k==0){
          result.add(new ArrayList<Integer>(temp));
          return;
        }
        
        for(int i= lastTime+1; i<= n; i++){
            temp.add(i);
            dfs(n, i, k-1,result,temp);
            temp.remove(temp.size()-1);
        }
        
    }
    

}