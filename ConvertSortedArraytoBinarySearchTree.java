public class ConvertSortedArraytoBinarySearchTree  { 
	
    int n; // to record the index of element from num
    
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
		// moves n from start to mid
		TreeNode left = sortedArrayToBST(num,start, mid - 1);
	    TreeNode root = new TreeNode(num[n]);
	    // each sortedArrayToBST function moves the pointer to the next one after its range
	    // this can be proved using induction
	   
	    // moves n from mid to mid+1
	    n++; 
	    // moves mid+1 to end+1
		TreeNode right = sortedArrayToBST(num,mid + 1, end);
 
		root.left = left;
		root.right = right;
 
		return root;
	}
}