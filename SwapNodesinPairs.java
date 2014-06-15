public class SwapNodesinPairs {
	
    public ListNode swapPairs(ListNode head) {
        
    	 if(head == null)
    		 return head;
    	        
    	 ListNode current = head;
    	        
        int listSize = 0;
        while(current !=null){
            listSize++;
            current = current.next;
        }
       
        ListNode front = head;
        ListNode end = head;
        ListNode swap = null;
        ListNode previous = head;
        
        // The reason to take the first operation as a special case 
        // is to assigning the head
        
        if(listSize >=2){
            
            front = head;
            end = head.next;
            
            front.next = end.next;
            end.next = front;
            swap = end;
            end = front;
            front = swap;
            head = front;
            previous = end;
          
            listSize -= 2;
        }
        
        
            
        while(listSize >= 2){
            
            front = front.next.next;
            end = end.next.next;
            
            front.next = end.next;
            end.next = front;
            swap = end;
            end = front;
            front = swap;
            previous.next = front;
            previous = previous.next.next;
       
           listSize -=2;        
        }
        
        return head;
    }
}