/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        
        if(p == null)
        return q == null;
        
        if(q == null)
        return p ==null;
        
        if(p.val == q.val){
            return isSameTree(p.left, q.left) &&  isSameTree(p.right, q.right);
        }
        
        return false;
    }
}