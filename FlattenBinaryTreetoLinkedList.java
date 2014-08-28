public class FlattenBinaryTreetoLinkedList {
	// flat the binary tree into a linked list in pre-order
    public void flatten(TreeNode root) {
        root = flattenHelper(root);
    }
    
    public TreeNode flattenHelper(TreeNode root) {
        
        if(root == null)
        return null;
        
        TreeNode left = flattenHelper(root.left);
        TreeNode right = flattenHelper(root.right);
        // disconnect root
        root.left =null;
        root.right =null;
        // append left list to root
        if(left != null)
            root.right = left;
        // get the last node  
        TreeNode scanner = root;   
        while( scanner.right != null)
            scanner = scanner.right;
        // append the right list to the end    
        scanner.right = right;
        
        return root;
    }
    
}