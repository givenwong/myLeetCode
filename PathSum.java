public class PathSum  {
    public boolean hasPathSum(TreeNode root, int sum) {
        // this is also the base case
        if(root == null)
        return false;
        // this is the base case
        if(root.left ==null && root.right == null)
        if(sum == root.val)
        return true;
                
        if(hasPathSum(root.left, sum-root.val))
        return true;
        
        if(hasPathSum(root.right, sum-root.val))
        return true;
       
        return false;
    }
}