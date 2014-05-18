/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class ReorderListFastI {
    
    public void reorderList(ListNode head) {
        
        if(head == null)
        return;
        

        ListNode scanner = head;
        int length =0;
        while(scanner != null){
            length++;
            scanner = scanner.next;
        }
        
        reorderHelper(head, length);
        
        
    }
    
    
    // helper returns the very last node's next node
    public ListNode reorderHelper(ListNode start, int range){
           
  
          if(range ==0)
            return null;
          
          ListNode result = null;
            
        // range == 1 and range ==2 cases don't need adjustment    
          if(range ==1){
              result = start.next;
              start.next = null;
              return result;
          }
          
          if(range ==2){
              result = start.next.next;
              start.next.next = null;
              return result;
          }
    
          
          ListNode temp = reorderHelper(start.next, range -2);
          
          result = temp.next;
          temp.next = start.next;
          start.next = temp;
           
        
         return result;
    }
    
}