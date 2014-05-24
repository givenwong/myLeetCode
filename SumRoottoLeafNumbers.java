import java.util.*;

public class SumRoottoLeafNumbers  {
    
    
	 public int sumNumbers(TreeNode root) {
	        int sum =0;        
	        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	        dfs(root, result, new ArrayList<Integer>());
	        for(ArrayList<Integer> a: result){
	            int thisTime =0;
	            for(Integer myBit: a){
	                thisTime = thisTime*10 + myBit;
	            }
	            sum += thisTime;
	        }
	        
	        return sum;
	        
	    }
	    
	    public void dfs(TreeNode root, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> temp){
	        
	           if(root == null)
	           return;
	           
	           if(root.left == null && root.right == null){
	             temp.add(root.val);
	             ArrayList<Integer> temptemp = new ArrayList<Integer>(temp);
	             result.add(temptemp);  
	             temp.remove(temp.size()-1);
	             return;
	               
	           }
	           
	           temp.add(root.val);
	           if(root.left != null)
	           dfs(root.left, result, temp); // assume dfs doesn't change temp here
	           if(root.right != null)
	           dfs(root.right, result, temp);
	           temp.remove(temp.size()-1);  // can prove dfs doesn't change temp eventually
	            
	           
	        
	    }
    
   public static void main(String[] args){
	   SumRoottoLeafNumbers mySolution = new SumRoottoLeafNumbers();
	   TreeNode root = new TreeNode(0);
	   TreeNode left = new TreeNode(1);
	   TreeNode right = new TreeNode(3);
	   root.left = left;
	   root.right = right;
	   int myResult = mySolution.sumNumbers(root);
	   System.out.println(myResult);
   } 
 

}