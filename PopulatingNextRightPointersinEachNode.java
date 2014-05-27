/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class PopulatingNextRightPointersinEachNode  {
    public void connect(TreeLinkNode root) {
        
        ArrayList<ArrayList<TreeLinkNode>> result = new ArrayList<ArrayList<TreeLinkNode>>();
        ArrayList<TreeLinkNode> myQueue = new ArrayList<TreeLinkNode>();
        
        if(root == null)
        return;
        
        myQueue.add(root);
        ArrayList<TreeLinkNode> first = new ArrayList<TreeLinkNode>();
        first.add(root);
        result.add(first);
        
        int thisLevel = 1;
        int nextLevel = 0;
        
        while(myQueue.size()>0){
    
            TreeLinkNode top = myQueue.get(0);
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
             ArrayList<TreeLinkNode> temp = new ArrayList<TreeLinkNode>();
             for(TreeLinkNode a: myQueue){
             temp.add(a);
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
        
        for(ArrayList<TreeLinkNode> a :result){
           for(int i =0; i<= a.size()-2;i++){
                a.get(i).next = a.get(i+1);             
           } 
                a.get(a.size()-1).next = null;
        }
        
    }
}