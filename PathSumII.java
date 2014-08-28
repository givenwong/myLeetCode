import java.util.*;

public class PathSumII  {
	
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
    
       ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
       dfs(root, sum, result, new ArrayList<Integer>());
       return result;
    }
    
    public void dfs(TreeNode root, int sum, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> temp ){
        
        if(root == null)
        return;
        // this is the base case
        if(root.left == null && root.right == null && root.val == sum){
            ArrayList<Integer> temptemp = new ArrayList<Integer>(temp);
            temptemp.add(root.val);
            result.add(temptemp);
            return;
        }
        
        temp.add(root.val);
        // assume dfs doesn't change the temp? How do you know if it is true?
        if(root.left != null){
        dfs(root.left, sum-root.val, result,temp);
        }
        if(root.right != null){
        dfs(root.right, sum-root.val, result,temp);
        }
        // this line guarantees dfs on root.left, root.right doesn't change temp!
        temp.remove(temp.size()-1);   
    }
}