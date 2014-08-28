/*Given a binary tree and a sum, 
 * determine if the tree has a !!!!!root-to-leaf !!!!! path such that 
 * adding up all the values along the path equals the given sum
 * 
 * The path ends at a LEAF !!!!!!!!!
 * */
public class PathSum  {
	
    public boolean hasPathSum(TreeNode root, int sum) {
        // this is also the base case
        if(root == null)
        return false;
        // this is the base case has reached the leaf
        if(root.left ==null && root.right == null && sum == root.val)
        return true;
                
        if(hasPathSum(root.left, sum-root.val))
        return true;
        
        if(hasPathSum(root.right, sum-root.val))
        return true;
       
        return false;
    }
}