public class ValidateBinarySearchTree  {
	
    public boolean isValidBST(TreeNode root) {        
    
    	return isValidBSTHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    
    }

    public boolean isValidBSTHelper(TreeNode root, int min, int max) {
        // min and max are for the range of tree rooted at root
    	
    	// !!!!!root == null gives the true, which is the base case
    	// in case get to the leaf or single child node
        if(root == null)
        return true;
        
        if((root.val < max) && (root.val > min)  )
            return isValidBSTHelper(root.left, min, root.val) && isValidBSTHelper(root.right, root.val, max);
       
        return false;
    }   
}