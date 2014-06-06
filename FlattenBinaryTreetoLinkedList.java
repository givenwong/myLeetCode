public class FlattenBinaryTreetoLinkedList {
	// flat the binary tree into a linked list in pre order
    public void flatten(TreeNode root) {
        root = flattenHelper(root);
    }
    
    public TreeNode flattenHelper(TreeNode root) {
        
        if(root == null)
        return null;
        
        TreeNode left = flattenHelper(root.left);
        TreeNode right = flattenHelper(root.right);
        
        root.left =null;
        root.right =null;
        
        if(left != null)
            root.right = left;
         
        TreeNode scanner = root;   
        while( scanner.right != null)
            scanner = scanner.right;
            
        scanner.right = right;
        
        return root;
    }
    

       
}