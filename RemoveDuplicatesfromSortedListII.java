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
public class RemoveDuplicatesfromSortedListII  {
    public ListNode deleteDuplicates(ListNode head) {
    
        if(head == null)
        return null;
        
        if(head.next == null)
        return head;
        
        ListNode fakeHead = new ListNode(0);
        ListNode scannerOne = head;
        ListNode scannerTwo = head;
        ListNode lastValid = fakeHead;
        
        while(scannerOne !=null){
            int dupCount = 1;
            while(scannerTwo.next != null && scannerTwo.next.val == scannerOne.val){
                dupCount++;
                scannerTwo = scannerTwo.next;
            }
            
            if(dupCount <=1 ){
                lastValid.next = scannerOne;
                lastValid = scannerOne;
                scannerTwo = scannerTwo.next;
                scannerOne = scannerTwo;
                lastValid.next = null;
            }else{
                scannerTwo = scannerTwo.next;
                scannerOne = scannerTwo;
            }
        }
        
        head = fakeHead.next;
        
        
        return head; 
    }
    
}