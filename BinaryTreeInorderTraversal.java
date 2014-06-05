import java.util.*;

public class BinaryTreeInorderTraversal {
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
     
    ArrayList<Integer> lst = new ArrayList<Integer>();
 
        if(root == null)
            return lst; 
          
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p = root;
 
        while(!stack.empty() || p != null){
 
            if(p != null){
                stack.push(p);
                // process the left branch first
                p = p.left; 
            }else{
            	// when goes to the left end of the left branch, process the middle point, then begin process
            	// the right branch (in the order of left middle right)
                TreeNode t = stack.pop();
                lst.add(t.val);
                p = t.right;
            }
        }
 
        return lst;
     
        
    }
}