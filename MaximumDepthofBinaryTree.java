public class MaximumDepthofBinaryTree {
    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        
        return 1 + (int)Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}