
public class ReverseNodesinkGroup {
    public ListNode reverseKGroup(ListNode head, int k) {

      int listSize = 0;
      
      
    
      ListNode current = head;
      ListNode previous = head;
   
    
      
      while(current != null){
          listSize++;
          current = current.next;
      }
      
      int secNum = listSize/k;
      
      
      if(secNum > 0){
          
          head = reverseK(head, k );
          current = head;
          previous = head;
          
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
        
        if(k == 0 || head == null)
            return null;
            
        ListNode temp = reverseK(head.next, k-1);    
        
        if(temp == null)
            return head;
        
        ListNode ite = temp;
        
        while(k>2){
            ite = ite.next;
            k--;
        }

        head.next = ite.next;
        ite.next = head;
        
        return temp;
    }
    
    
    
    
    
}