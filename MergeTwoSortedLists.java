public class MergeTwoSortedLists  {
	
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
        if(l1 == null)
        return l2;
        
        if(l2 == null)
        return l1;
        
        ListNode head = null;
        ListNode first = l1;
        ListNode second = l2;
        ListNode sum = null;
        // the first 
        if(first.val < second.val){
        head = first;
        first = first.next;
        }
        else{
        head = second;
        second = second.next;
        }

        sum = head;
        while(first != null && second !=null){
              if(first.val < second.val){
              sum.next =first;
              first = first.next;
              }else{
              sum.next = second;
              second = second.next;
              }
            sum = sum.next;
        }
        
           if(first != null)
            sum.next =first;
     
           if(second != null)
            sum.next =second;
       
           
        return head;    
    }
}