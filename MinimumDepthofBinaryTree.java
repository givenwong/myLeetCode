/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class MinimumDepthofBinaryTree  {
    public int minDepth(TreeNode root) {
        
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