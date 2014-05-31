/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class ConvertSortedArraytoBinarySearchTree  {
    
    static int n;
    
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
		n++;
	
		TreeNode right = sortedArrayToBST(num,mid + 1, end);
 
		root.left = left;
		root.right = right;
 
		return root;
	}
    
}