/*
 * Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
*/

public class BalancedBinaryTree {
	
    public boolean isBalanced(TreeNode root) {
      
    	// this is the base case
        if(root ==null)
        return true;
        
        if(isBalanced(root.left) && isBalanced(root.right) && (int)Math.abs(treeDepth(root.left) -treeDepth(root.right)) <=1)
        return true;
        
        return false;       
    }
    
    public int treeDepth(TreeNode root){
    	
        if(root == null)
        return 0;
       
        return 1+(int)Math.max(treeDepth(root.left),treeDepth(root.right));
    }
}