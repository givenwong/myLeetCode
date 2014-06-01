/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class FlattenBinaryTreetoLinkedList {
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