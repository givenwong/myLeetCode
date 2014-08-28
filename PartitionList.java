public class PartitionList  {
    
	public ListNode partition(ListNode head, int x) {
        
        if(head == null || head.next == null)
        return head;
        
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        ListNode addingPoint = fakeHead;
        ListNode scanner = head;
        // skip all the small numbers
        while(scanner != null && scanner.val < x){
            scanner = scanner.next;
            addingPoint = addingPoint.next;
        }
        
        ListNode relay = scanner; // relay is the first big number
        
        if(scanner == null)
        return head;
        
        while(relay.next != null){
        	// relay is now the probe
        	
        	// process the small number: append it to the end of the addingPoint
            if(relay.next.val < x){
            
            ListNode temp = addingPoint.next;
            addingPoint.next = new ListNode(relay.next.val);
            addingPoint.next.next = temp; 
            addingPoint = addingPoint.next;
            // skip the small number by directly connect to its next one
            relay.next =relay.next.next;
            
            }else{
                // find the next big number
            	relay = relay.next;    
            }
        }
        
        return fakeHead.next;
    }
}