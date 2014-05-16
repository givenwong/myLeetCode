
public class SortList {
    
    public ListNode sortList(ListNode head) {
        
        head = mergeSort(head);
        return head;
        
    }
    
    
    
    
    ListNode mergeSort(ListNode head){
        
        // Any recursion must have the base case
        if(head == null)
            return null;
        if(head.next == null)
            return head;
        
        // there are at least two nodes afterwards which means we have nonempty left and right lists
        
        ListNode left = null;
        ListNode right = null;
        
        ListNode slow = head;
        ListNode fast = head.next;
          
        while(fast != null && fast.next != null){
            
               slow = slow.next;
               fast = fast.next.next;
            
        }
            
            right = slow.next;
            left = head;
            slow.next = null;
            
      
        left = mergeSort(left);
        right = mergeSort(right);
        
    
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
     
     
 
        return head;
    }
     
 
    
}