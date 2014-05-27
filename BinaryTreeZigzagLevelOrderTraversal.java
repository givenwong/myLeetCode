import java.util.ArrayList;

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BinaryTreeZigzagLevelOrderTraversal {
	  public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
	        
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
	        boolean startFromLeft = true;
	        
	        while(myQueue.size()>0){
	    
	            TreeNode top = myQueue.get(0);
	            myQueue.remove(0);
	            
	        
	            if(top.left != null)
	            myQueue.add(top.left);
	            if(top.right != null)
	            myQueue.add(top.right);
	         
	            
	            if(thisLevel ==1){
	            	
	             startFromLeft = (!startFromLeft);	
	             if(top.left != null && top.right != null)    
	             thisLevel = nextLevel+2;
	             if((top.left != null && top.right == null)||(top.left == null && top.right != null) )    
	             thisLevel = nextLevel+1;
	             if(top.left == null && top.right == null)    
	             thisLevel = nextLevel;
	             nextLevel =0;
	             ArrayList<Integer> temp = new ArrayList<Integer>();
	            
	            if(startFromLeft){ 
	                
	            for(TreeNode a: myQueue){
	             temp.add(a.val);
	            }
	                
	            }else{
	             for(int i = myQueue.size()-1; i>=0 ;i--){
	             temp.add(myQueue.get(i).val);
	            }
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
    	
	 BinaryTreeZigzagLevelOrderTraversal mySolution = new BinaryTreeZigzagLevelOrderTraversal();
    	
    	TreeNode one = new TreeNode(1);
    	TreeNode two = new TreeNode(2);
    	TreeNode three = new TreeNode(3);
    	TreeNode four = new TreeNode(4);
    	TreeNode five = new TreeNode(5);
    	one.left=two;
    	one.right=three;
    	two.left = four;
    	two.right= five;
    	
    	ArrayList<ArrayList<Integer>> myResult = mySolution.zigzagLevelOrder(one);
    	System.out.println(myResult);
        
    }
}