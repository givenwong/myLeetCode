
public class ReorderListSlow  {
    
    public void reorderList(ListNode head) {
        
        if(head == null)
        return;
        
        if(head.next ==null)
        return;
        
        if(head.next.next == null)
        return;
        
        
        
        ListNode scanner = head;
        int length =0;
        while(scanner != null){
            length++;
            scanner = scanner.next;
        }
        
        head = reorderHelper(head, length);
        
        
    }
    
    
    public ListNode reorderHelper(ListNode start, int range){
           
          ListNode scanner =start;
          ListNode last = start;
          int count = range-2;
          
          if(range ==0)
            return null;
            
          if(range ==1)
            return start;
        
          
          while(count >0){
              count--;
              scanner = scanner.next;
          }
          
          last = scanner.next;
          scanner.next = null;
          
          ListNode temp = reorderHelper(start.next, range -2);
          
          start.next = last;
          last.next = temp;
           
        
         return start;
    }
       
}