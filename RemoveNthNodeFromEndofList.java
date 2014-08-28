import java.util.*;

// Here is the definition of the listNode and it is used by all java programs
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
        
        while(n>1) {
            end = end.next;
            n--;
        }
        
        while(end.next != null){
            
        	// !!!!! Attention this is the way to record the previous one, usually for deletion !!!!!
        	temp = front; 
        	
            front = front.next;
            end = end.next;
        }
        
        // this is for the case the one needs to be deleted is the head
        if( front == head)
        return head.next;
        
        // the deletion happens here: front points to the n th element from the end
        temp.next = front.next;
        
        return head;
         
    }
}
