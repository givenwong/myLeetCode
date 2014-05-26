/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

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
        
        if(root.left == null && root.right == null && root.val == sum){
            ArrayList<Integer> temptemp = new ArrayList<Integer>(temp);
            temptemp.add(root.val);
            result.add(temptemp);
            return;
        }
        
        temp.add(root.val);
        if(root.left != null){
        dfs(root.left, sum-root.val, result,temp);
        }
        if(root.right != null){
        dfs(root.right, sum-root.val, result,temp);
        }
        temp.remove(temp.size()-1);
        
    }
}