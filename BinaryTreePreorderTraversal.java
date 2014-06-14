import java.util.*;

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }

public class BinaryTreePreorderTraversal  {
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        
        ArrayList<Integer> result = new ArrayList<Integer>();
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