/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
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
        
           while(first != null){
            
            sum.next =first;
            sum = sum.next;
            first = first.next;
       
        }
        
              while(second != null){
            
            sum.next =second;
            sum = sum.next;
            second = second.next;
       
        }
        
        
        return head;
        
    }
}