
public class InsertionSort {
	
    public ListNode insertionSortList(ListNode head) {
    	
        if(head == null || head.next == null)
			return head;
        
		ListNode pivot = head.next;
		
		while(pivot != null)
		{
			ListNode tmp = head;
			
			while(tmp.val < pivot.val && tmp != pivot)//first node whose value greater than pivot value
				tmp = tmp.next;
			
			if(tmp != pivot) // first node whose val > pivot val is found
			{
				while(tmp != pivot)
				{
					int tmpvalue = tmp.val;
					tmp.val = pivot.val;
					pivot.val = tmpvalue;
					tmp = tmp.next;
				}
			}
			
			pivot = pivot.next;
		}
		return head;
    }
}