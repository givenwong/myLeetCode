public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        
        if(root == null)
        return true;
        
      return isMirror(root.left, root.right);  
    }
    
    public boolean isMirror(TreeNode rootOne, TreeNode rootTwo){
    
        if(rootOne == null)
        return rootTwo == null;
        if(rootTwo == null)
        return rootOne == null;
    
        boolean result = (rootOne.val == rootTwo.val)&&isMirror(rootOne.left, rootTwo.right)&&isMirror(rootOne.right, rootTwo.left);
        return result;   
    }
}