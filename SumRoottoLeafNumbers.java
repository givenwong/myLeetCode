import java.util.*;

public class SumRoottoLeafNumbers  {
    
	 public int sumNumbers(TreeNode root) {
		 
	        int sum =0;        
	        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	        dfs(root, result, new ArrayList<Integer>());
	     
	        for(ArrayList<Integer> a: result){
	            // convert each list of integers to a number
	        	int thisTime =0;
	            for(Integer myBit: a){
	                thisTime = thisTime*10 + myBit;
	            }
	            
	            sum += thisTime;
	        }
	        
	        return sum;  
	    }
	    
	    public void dfs(TreeNode root, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> temp){
	           // this is a base case. why, suppose it is from a node with only a left child and no right child
	           // this is the "right child"
	    	   if(root == null)
	           return;
	           
	           if(root.left == null && root.right == null){
	             temp.add(root.val); // assume dfs doesn't change temp here
	             ArrayList<Integer> temptemp = new ArrayList<Integer>(temp);
	             result.add(temptemp);  
	             temp.remove(temp.size()-1); // assume dfs doesn't change temp here !!!!!!!!!
	             return;    
	           }
	           
	           temp.add(root.val);
	           // branch to the left subtree
	           if(root.left != null)
	           dfs(root.left, result, temp); // assume dfs doesn't change temp here
	           // branch to the right subtree
	           if(root.right != null)
	           dfs(root.right, result, temp);
	           temp.remove(temp.size()-1);  // make sure the dfs doesn't modify temp   
	    }
	    
}