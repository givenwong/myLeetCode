public class InsertionSort {
	 public ListNode insertionSortList(ListNode head) {
    	
        if(head == null || head.next == null)
			return head;
        // pivot is the scanner to get new element
        // list prior to pivot is already sorted
		ListNode pivot = head.next;
		while(pivot != null) {
			// tmp is a scanner to find the proper position for pivot.
			ListNode tmp = head;
			// to get the first node whose value greater than pivot value in the already sorted part
			while(tmp.val < pivot.val && tmp != pivot)
				tmp = tmp.next;
		
		    while(tmp != pivot) { // there is no node operations, just to change the labels!
					int tmpvalue = tmp.val;
					tmp.val = pivot.val;
					pivot.val = tmpvalue;
					
					tmp = tmp.next;
				}
		    
			pivot = pivot.next;
		}
		return head;
    }
}