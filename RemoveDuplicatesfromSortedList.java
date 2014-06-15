public class RemoveDuplicatesfromSortedList  {
	
    public ListNode deleteDuplicates(ListNode head) {
        
        if(head ==null)
        return null;
        
        if(head.next ==null)
        return head;
        
        ListNode slow = head;
        ListNode fast = head.next;
        
        while(fast != null){
            
            if(slow.val != fast.val){
                slow.next = fast;
                slow = slow.next;
                fast = fast.next;
                continue;
            }
            
            if(slow.val == fast.val){
             
                fast = fast.next;
            }
            
        }
        // to isolate the result list from all the duplicates
        slow.next = null;
        
        return head;
    }
}