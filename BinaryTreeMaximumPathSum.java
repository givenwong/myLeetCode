public class BinaryTreeMaximumPathSum  {
  // this is NOT a class/static var but an instance var/regular filed of this class
	int max; 
	
	public int maxPathSum(TreeNode root) {
		// initialize max
		max = (root == null) ? 0 : Integer.MIN_VALUE;
		findMax(root);
		return max;
	}
 
	
	// return value is the ONE-SIDE path's max value including the current node. 
	// this return value is zero if the ONE-SIDE path's max value including the current node is negative	
	// the method also updates the max (the result) value in its subtree
	public int findMax(TreeNode node) {
		
		if (node == null)
			return 0;

		int left = findMax(node.left); // not only returns but also updates the max
		int right = findMax(node.right); // not only returns but also updates the max
		//update maximum here: the only possible challenger for max is node.val+left+right
		max = Math.max(node.val + left + right, max);
		// return value is the ONE-SIDE path's max value including the current node.
		// node.val may be negative
		return Math.max(node.val + Math.max(left, right),0);
	}
}