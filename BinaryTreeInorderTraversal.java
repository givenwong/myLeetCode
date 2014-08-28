import java.util.*;

public class BinaryTreeInorderTraversal {

	public ArrayList<Integer> inorderTraversal(TreeNode root) {
     
    ArrayList<Integer> list = new ArrayList<Integer>();
 
        if(root == null)
            return list; 
          
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p = root;

        while(!stack.empty() || p != null){
 
        	// process the left branch first
            if(p != null){
                stack.push(p);
                p = p.left; 
            }else{
            	// when goes to the left end of the left branch, process the middle point, 
            	// then begin processing
            	// then right branch (in the order of left middle right)
                TreeNode t = stack.pop();
                list.add(t.val);
                p = t.right;
            }
            
        }
 
        return list;
    }
}