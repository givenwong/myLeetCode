/*Given a sorted linked list, delete all nodes that have duplicate numbers, 
 * leaving only distinct numbers from the original list.

For example,
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3.*/
public class RemoveDuplicatesfromSortedListII  {
	
    public ListNode deleteDuplicates(ListNode head) {
    
        if(head == null)
        return null;
        
        if(head.next == null)
        return head;
        
        // Why fake head? the original head itself may be a dup and then need to be deleted
        ListNode fakeHead = new ListNode(0);
        ListNode scannerOne = head; // scannerOne is at the start of the dups
        ListNode scannerTwo = head; // scannerTwo is at the end of the dups
        ListNode lastValid = fakeHead;// lastValid is the growing point of the result
        
        while(scannerOne !=null){
        	
        	// the inner loop is to put scannerTwo at the very last one of the dups
        	// at the same time count the dups to see if there are dups
            int dupCount = 1;
            while(scannerTwo.next != null && scannerTwo.next.val == scannerOne.val){
                dupCount++;
                scannerTwo = scannerTwo.next;
            }
            
            if(dupCount ==1 ){
                lastValid.next = scannerOne;
                lastValid = scannerOne;
                scannerTwo = scannerTwo.next;
                scannerOne = scannerTwo;
                lastValid.next = null;
            }else{
                scannerTwo = scannerTwo.next;
                // skip the ALL the dups
                scannerOne = scannerTwo;
            }
        }
        
        head = fakeHead.next;
      
        return head; 
    }
    
}