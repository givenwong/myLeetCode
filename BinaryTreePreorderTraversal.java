import java.util.*;

// no matter pre/in/post order, have to use stack because it is dfs in nature
// queue only gives level order traversal result

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }

public class BinaryTreePreorderTraversal  {
    
	public ArrayList<Integer> preorderTraversal(TreeNode root) {
        
        ArrayList<Integer> result = new ArrayList<Integer>();
        // here stack is used rather than a queue. Why? Queue gives level traversal.
        ArrayList<TreeNode> stack =  new ArrayList<TreeNode>();
        
        if(root == null)
            return result;
            
        stack.add(root);
        while(stack.size() != 0){
        	
            TreeNode temp = stack.get(stack.size()-1);
            stack.remove(stack.size()-1);
            
            result.add(temp.val);
            // right goes first because there is only one stack
            // if there are two stack, left goes first
            if(temp.right != null)
               stack.add(temp.right); 
            if(temp.left != null)
               stack.add(temp.left);
        }
        return result;
    }
}