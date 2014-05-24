/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        
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