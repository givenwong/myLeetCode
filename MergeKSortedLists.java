import java.util.*;

public class  MergeKSortedLists {

	public ListNode mergeKLists(ArrayList<ListNode> lists) {
        // the result to return
        ListNode result = null;
        // the returned left part
        ListNode resultLeft = null;
        // the returned right part
        ListNode resultRight = null;
        // the left and right parts of the original list
        ArrayList<ListNode> left = new ArrayList<ListNode>() ;
        ArrayList<ListNode> right = new ArrayList<ListNode>();
        
        if(lists == null)
        return null;
        
        if(lists.size() == 0)
        return result;
        
        if(lists.size()==1)
        return (ListNode)lists.get(0);
        
        for(int i =0; i <= lists.size()/2-1; i++){
        	if (lists.get(i) != null)
        	left.add((ListNode)lists.get(i));
        }
        
        for(int i = lists.size()/2; i <= lists.size()-1; i++){
        	if (lists.get(i) != null)
            right.add((ListNode)lists.get(i));
        }
        
         resultLeft = mergeKLists(left);
         resultRight = mergeKLists(right);   
         
         ListNode current = null;
         
         if(resultLeft != null && resultRight != null){
         
         if(resultLeft.val <= resultRight.val){
             result = new ListNode(resultLeft.val);
             resultLeft = resultLeft.next; 
         }
             else{
             result = new ListNode(resultRight.val);
             resultRight = resultRight.next; 
             }
         
           current = result;
         }
         
         while(resultLeft != null && resultRight != null){
             if(resultLeft.val <= resultRight.val) {
             ListNode temp = new ListNode(resultLeft.val);
             current.next = temp;
             current = current.next;
             resultLeft = resultLeft.next;  
             }else{
             ListNode temp = new ListNode(resultRight.val);
             current.next = temp;
             current = current.next;
             resultRight = resultRight.next;
             }
         }
         
         
         ListNode leftOver = (resultLeft == null) ? resultRight : resultLeft;
         
         if(leftOver == null)
         return result;
         
         if(current != null)
         current.next = leftOver;
         else
         result = leftOver;
         
         return result;
          
    }
}