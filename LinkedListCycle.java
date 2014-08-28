public class LinkedListCycle  {
    public boolean hasCycle(ListNode head) {
        
          if(head == null || head.next == null)
            return false;
            
          ListNode fast = head;
          ListNode slow = head;
          
          // fast moves 2 steps each time so need to check if fast is null and if fast.next is null
          while(fast != null && fast.next != null ){
              slow = slow.next;
              fast = fast.next.next;
              
              if(slow == fast)
                return true;
          }
        return false;
    }
}