/* p is for the first displacement which is the bigger one
 * q is for the 2nd displacement which is the smaller one
 * pre is the previously visited tree node
 * 
 * the idea: if the tree is a BST then an in-order traversal should produce an ordered sequence
 * */

public class RecoverBinarySearchTree {
	
	// two ways to return more than one values:
	// 1. array
	// 2. use the fields in class definition and modify the fields
	
	
	// these are the fields of the class
    TreeNode p;
    TreeNode q;
    TreeNode pre;
    
   
    
   public void recoverTree(TreeNode root) {
    
	   if (root == null)
    	return;
      
	  getWrong(root);
      
	  int tmp = p.val;
      p.val = q.val;
      q.val = tmp;
    }
    
    // get wrong is virtually the inoder traversal 
    public void getWrong(TreeNode root) {
        // root is the node which is being visited
    	if (root == null) 
    		return;
    	// scan the left part first
    	// get wrong 1 labels the wrong points
    	//           2 move the pointer to the most recently visited point              
        getWrong(root.left);
        
        // pre != null is to prevent null pointer exception
        // root is supposed to be greater than pre
        
        if (pre != null && root.val < pre.val) {
        
        if (p == null) {
        // first time to meet the disorder, the bigger one is the wrong one 	
        p = pre;
        q = root;
        }else 
          q = root; // the 2nd time to meet the disorder, the smaller one is the wrong one
        
        }
        
        // for the right tree the previously visited is the root
        pre = root;
        getWrong(root.right);
    }
}