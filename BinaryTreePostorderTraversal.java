import java.util.*;
public class BinaryTreePostorderTraversal {
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        ArrayList<TreeNode> stackOne = new ArrayList<TreeNode>();
        ArrayList<TreeNode> stackTwo = new ArrayList<TreeNode>();// it is the reversed ordered result
        
        
        if(root == null)
        return result;
        
        stackOne.add(root);
        
        while(stackOne.size() != 0){
            
            TreeNode temp = stackOne.get(stackOne.size()-1);
            stackOne.remove(stackOne.size()-1);
            stackTwo.add(temp); 
            
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