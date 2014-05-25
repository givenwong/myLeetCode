/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class ValidateBinarySearchTree  {
    public boolean isValidBST(TreeNode root) {
        
        
        return isValidBSTHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        
    }

    public boolean isValidBSTHelper(TreeNode root, int min, int max) {
        
        if(root == null)
        return true;
        
        
        
        if((root.val < max) && (root.val > min)  ){
            return isValidBSTHelper(root.left, min, root.val) && isValidBSTHelper(root.right, root.val, max);
        }
        
        return false;
    }   
}