public class MinimumDepthofBinaryTree  {
	
    public int minDepth(TreeNode root) {
        // this is not a base case but a corner case
    	// why not a base case?
    	// there is no way to recurse on a null node 
        if(root == null)
        return 0;
        
        if((root.right == null && root.left == null))
        return 1;
        
        if(root.right == null && root.left != null)
        return 1+ minDepth(root.left);
        
        if(root.right != null && root.left == null)
        return 1+ minDepth(root.right);
        
        return 1+ (int)Math.min(minDepth(root.left), minDepth(root.right));       
    }
}