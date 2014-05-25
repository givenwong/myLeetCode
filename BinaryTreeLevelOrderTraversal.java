import java.util.*;

public class BinaryTreeLevelOrderTraversal  {
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<TreeNode> myQueue = new ArrayList<TreeNode>();
        
        if(root == null)
        return result;
        
        myQueue.add(root);
        ArrayList<Integer> first = new ArrayList<Integer>();
        first.add(root.val);
        result.add(first);
        
        int thisLevel = 1;
        int nextLevel = 0;
        
        while(myQueue.size()>0){
    
            TreeNode top = myQueue.get(0);
            myQueue.remove(0);
            
            if(top.left != null)
            myQueue.add(top.left);
            if(top.right != null)
            myQueue.add(top.right);
            
            if(thisLevel ==1){
             if(top.left != null && top.right != null)    
             thisLevel = nextLevel+2;
             if((top.left != null && top.right == null)||(top.left == null && top.right != null) )    
             thisLevel = nextLevel+1;
             if(top.left == null && top.right == null)    
             thisLevel = nextLevel;
            
             nextLevel =0;
             ArrayList<Integer> temp = new ArrayList<Integer>();
             for(TreeNode a: myQueue){
             temp.add(a.val);
            }
             if(temp.size() >0)
            result.add(temp);
                
            }else{
                thisLevel--;
             
             if(top.left != null && top.right != null)    
             nextLevel = nextLevel+2;
             if((top.left != null && top.right == null)||(top.left == null && top.right != null) )    
             nextLevel = nextLevel+1;
         
            }         
            
        }
        
     return result;
        
    }
    
    public static void main(String[] args){
    	
    	BinaryTreeLevelOrderTraversal  mySolution = new BinaryTreeLevelOrderTraversal ();
    	
    	TreeNode one = new TreeNode(1);
    	TreeNode two = new TreeNode(2);
    	TreeNode three = new TreeNode(3);
    	TreeNode four = new TreeNode(4);
    	TreeNode five = new TreeNode(5);
    	one.left=two;
    	one.right=three;
    	two.left = four;
    	three.right= five;
    	
    	ArrayList<ArrayList<Integer>> myResult = mySolution.levelOrder(one);
    	System.out.println(myResult);
        
    }
}