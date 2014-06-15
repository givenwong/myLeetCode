public class ReverseNodesinkGroup {

	public ListNode reverseKGroup(ListNode head, int k) {

      int listSize = 0;
      
      ListNode current = head;  // current points to the start of each section
      ListNode previous = head; // previous points to the last of the previous section
   
      while(current != null){
          listSize++;
          current = current.next;
      }
      
      int secNum = listSize/k;
         
      if(secNum > 0){
          
          head = reverseK(head, k );
          current = head; 
          previous = head;
          
          // point the current to the start of the next section
          int leftOver = k;
          while(leftOver > 0){
              current = current.next;
              leftOver--;
          }
          
          // point the previous to the end of this section
          int previousPos = k;
          while(previousPos > 1){
              previous = previous.next;
              previousPos--;
          }
          
          secNum--;
      }
      
      while(secNum > 0){
         
          previous.next = reverseK(current, k );
          current = previous.next;
          previous = previous.next;
         
          int leftOver = k;
          while(leftOver > 0){
              current = current.next;
              leftOver--;
          }
          
          int previousPos = k;
          while(previousPos > 1){
              previous = previous.next;
              previousPos--;
          }
            
          secNum--;
      }
      
      
      return head;
       
    }
    
    
    // returns the head of the reversed list
    ListNode reverseK(ListNode head, int k ){
        
    	// k == 0 is the base case
        if(k == 0 || head == null)
            return null;
            
        ListNode temp = reverseK(head.next, k-1);    
        
        // k == 1 return head  k ==0 is the base case
        if(temp == null)
            return head;
        
        ListNode ite = temp;
        
        while(k>2){
            ite = ite.next;
            k--;
        }
        
        // ite.next points to the start of the next section
        head.next = ite.next;
        ite.next = head;
        
        return temp;
    }
    
}