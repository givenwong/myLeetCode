import java.util.*;


   class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }

public class RemoveNthNodeFromEndofList  {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        ListNode front = head;
        ListNode end = head;
        ListNode temp = head;
        
        while(n>1){
            end = end.next;
            n--;
        }
        
        while(end.next != null){
            temp = front;
            front = front.next;
            end = end.next;
            
        }
        
        
       
        if(temp == front)
        return head.next;
        
        
        temp.next = front.next;
        
     
        return head;
         
        
       
        
        
    }
}
