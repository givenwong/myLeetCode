public class LinkedListCycleII  {
    public ListNode detectCycle(ListNode head) {
        
        ListNode result= null;
        
        if(head == null || head.next == null)
            return null;
            
        ListNode fast = head;
        ListNode slow = head;
            
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)
                break;  
        }    
        
        if(slow == null || fast == null)
         return null;
        
        ListNode aux = head;
        while(aux != null && slow != null && aux != slow ){
            aux = aux.next;
            slow = slow.next;
        }
   
       if(aux == slow)
       return aux;        
       else 
       return null;
    }
}