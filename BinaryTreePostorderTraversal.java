import java.util.*;
public class BinaryTreePostorderTraversal {
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        
        ArrayList<Integer> result = new ArrayList<Integer>();
        ArrayList<TreeNode> stackOne = new ArrayList<TreeNode>();
        // this stack is a swap to reverse the order
        ArrayList<TreeNode> stackTwo = new ArrayList<TreeNode>();
        
        if(root == null)
        return result;
        
        stackOne.add(root);
        while(stackOne.size() != 0){
            
            TreeNode temp = stackOne.get(stackOne.size()-1);
            stackOne.remove(stackOne.size()-1);
            // in the reversed post order, middle node is the first
            stackTwo.add(temp); 
            
            // left is first so left enters stackOne earlier and it'll get popped later
            // so it enters stackTwo later so it gets popped out earlier than right
            if(temp.left != null)
                stackOne.add(temp.left);
            if(temp.right != null)
                stackOne.add(temp.right);
            
        }
        
        while(stackTwo.size() != 0){
            result.add(stackTwo.get(stackTwo.size()-1).val);
            stackTwo.remove(stackTwo.size()-1); 
        }
        return result;
    }
}