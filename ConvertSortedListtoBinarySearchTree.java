public class ConvertSortedListtoBinarySearchTree {
  ListNode h;
  
	public TreeNode sortedListToBST(ListNode head) {
		if (head == null)
			return null;
 
		h = head;
		int len = getLength(head);
		return sortedListToBST(0, len - 1);
	}
	// get list length: shouldn't use this in the recursive function
	public int getLength(ListNode head) {
		int len = 0;
		ListNode p = head;
 
		while (p != null) {
			len++;
			p = p.next;
		}
		return len;
	}
 
	// build tree bottom-up
	// moves h to the next node of the end node
	// this can be proved by induction
	public TreeNode sortedListToBST(int start, int end) {
		if (start > end)
			return null;
 
		// mid
		int mid = (start + end) / 2;
        // moves from start to mid in the list
		TreeNode left = sortedListToBST(start, mid - 1);
		TreeNode root = new TreeNode(h.val);
		h = h.next;
		// moves from mid+1 to end+1 in the list
		TreeNode right = sortedListToBST(mid + 1, end);
 
		root.left = left;
		root.right = right;
 
		return root;
	}
}