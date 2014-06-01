public class ConstructBinaryTreefromPreorderandInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int inStart = 0;
        int inEnd = inorder.length-1;
        int preStart =0;
        int preEnd = preorder.length-1;
 
        return buildTree(preorder, preStart, preEnd, inorder, inStart, inEnd);
    }
 
    public TreeNode buildTree( int[] preorder, int preStart, int preEnd,int[] inorder, int inStart, int inEnd){
        if(inStart > inEnd || preStart > preEnd)
            return null;
 
        int rootValue = preorder[preStart];
        TreeNode root = new TreeNode(rootValue);
 
        int k=0;
        for(int i=0; i< inorder.length; i++){
            if(inorder[i]==rootValue){
                k = i;
                break;
            }
        }
 
        root.left = buildTree(preorder, preStart+1, preStart+k-inStart,inorder, inStart, k-1);
        root.right = buildTree(preorder, preStart+k-inStart+1, preEnd,inorder, k+1, inEnd );
        
 
        return root;
    }
}