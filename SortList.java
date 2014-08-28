public class SortList {
    
    public ListNode sortList(ListNode head) {
     
        head = mergeSort(head);
        return head;       
    }
    
    // a recursion
    ListNode mergeSort(ListNode head){
        
        // this is a base case
    	// why two base cases? if the size of the list is 1, then the recursions will be one with 0-size list and 
    	// the other with 1-size list
        if(head == null)
            return null;
        // this is a base case
        if(head.next == null)
            return head;
        
        // there are at least two nodes afterwards which means we have nonempty left and right lists
        ListNode left = null;
        ListNode right = null;
        
        ListNode slow = head;
        ListNode fast = head.next;
        // why fast != null and fast.next != null, ie test twice? because fast moves 2X speed  
        while(fast != null && fast.next != null){
            
               slow = slow.next;
               fast = fast.next.next;
        }
            // split the whole list into left half and right half
            right = slow.next;
            left = head;
            slow.next = null;
              
        left = mergeSort(left);
        right = mergeSort(right);
        
        // why the first node is peculiar? because need to anchor the head to one of the left/right node 
        // and this can't be done in a repetitive manner (in the while). It is one shot.
        ListNode current = null;
       
              if(left.val < right.val){
                  head = left;
                  current = head;
                  left = left.next;
                  current.next = null;
              }else{
                   head = right;
                   current = head;
                   right = right.next;
                   current.next = null;
              }
                 
        while(left != null && right != null){
            
               if(left.val < right.val){
                  current.next = left;
                  left = left.next;
                  current = current.next;
                  current.next = null;
              }else{
                   current.next = right;
                   right = right.next;
                   current = current.next;
                   current.next = null;   
              }
        }
       
      if(left != null){
          current.next = left;
          return head;
      }
      
      if(right != null){
          current.next = right;
          return head;
      }
        // by logic this part is never reached as can not be left == null and right == null at the same time
        return head;
    }
    
   
}