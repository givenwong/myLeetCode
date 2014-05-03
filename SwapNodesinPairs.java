public class SwapNodesinPairs {
    public ListNode swapPairs(ListNode head) {
        
        int listSize = 0;
        
        if(head == null)
        return head;
        
        ListNode current = head;
       
        
        while(current !=null){
            listSize++;
            current = current.next;
        }
        
        
        if(listSize % 2 == 1 )
            listSize--;
        
        
        
        ListNode front = head;
        ListNode end = head;
        ListNode swap = null;
        ListNode previous = head;
        
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