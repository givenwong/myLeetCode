public class PopulatingNextRightPointersinEachNodeIIAC {
	
    public void connect(TreeLinkNode root) {
        
       if (root == null) 
            return;
        // the right siblings are already connected
        // in root's parent node's code, root's right siblings are done
        TreeLinkNode p = root.next;
        
        while (p != null) {
        	
            if (p.left != null) {
                p = p.left;
                break;
            }
            
            if (p.right != null) {
                p = p.right;
                break;
            }
            
            p = p.next;
        }
        
        

        if (root.right != null) {
            root.right.next = p; // null is a possible value for p
        }

        if (root.left != null) {
            root.left.next = (root.right == null) ? p : root.right;
        }

        connect(root.right); // right first
        connect(root.left);  // left later
    }
        
    
}