public class ConvertSortedArraytoBinarySearchTree  {
    
    int n;
    public TreeNode sortedArrayToBST(int[] num) {
        
        n =0;
        TreeNode result = sortedArrayToBST(num, 0, num.length-1); 
        return result;
   
    }
    
    	public TreeNode sortedArrayToBST(int[] num, int start, int end) {
		
		if (start > end)
			return null;
 
		// mid
		int mid = (start + end) / 2;
 
		TreeNode left = sortedArrayToBST(num,start, mid - 1);
	    TreeNode root = new TreeNode(num[n]);
	    // each sortedArrayToBST function moves the pointer to the next one after its range
	    n++; 
		TreeNode right = sortedArrayToBST(num,mid + 1, end);
 
		root.left = left;
		root.right = right;
 
		return root;
	}
    
}