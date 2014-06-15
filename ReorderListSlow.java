// This doesn't pass leetcode testing case
// The reason is there is a O(n) operation in each recursion

// Another way takes 3 steps and doesn't use recursion
// 1. split the list into 2
// 2. reverse the 2nd list
// 3. merge the two lists
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
           
          // last points to the last node in the range
    	 
          
          if(range ==0)
            return null;
            
          if(range ==1)
            return start;
          
          ListNode scanner =start;
          int count = range-2;
          while(count >0){
              count--;
              scanner = scanner.next;
          }
          // scanner is at the 2nd last node
          ListNode last  = scanner.next;
          scanner.next = null;
          
          ListNode temp = reorderHelper(start.next, range -2);
          
          start.next = last;
          last.next = temp;
           
         return start;
    }
       
}