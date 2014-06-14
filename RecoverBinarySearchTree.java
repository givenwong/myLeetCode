/* p is for the first displacement which is the bigger one
 * q is for the 2nd displacement which is the smaller one
 * pre is the previously visited tree node
 * 
 * the idea: if the tree is a BST then an in-order traversal should produce an ordered sequence
 * */

public class RecoverBinarySearchTree {
    TreeNode p,q;
    TreeNode pre;
    
   public void recoverTree(TreeNode root) {
    if (root == null) return;
      getWrong(root);
      int tmp = p.val;
      p.val = q.val;
      q.val = tmp;
    }
    
    public void getWrong(TreeNode root) {
        // root is the node which is being visited
    	if (root == null) return;
    	// scan the left part first
        getWrong(root.left);
        // pre != null is to prevent null pointer exception
        if (pre != null && root.val < pre.val) {
        if (p == null) {
        // first time to meet the disorder 	
        p = pre;
        q = root;
         }else q = root; // the 2nd time to meet the disorder
        }
        // for the right tree the previously visited is the root
        pre = root;
        getWrong(root.right);
    }
}