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
public class PartitionList  {
    public ListNode partition(ListNode head, int x) {
        
        if(head == null || head.next == null)
        return head;
        
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        ListNode addingPoint = fakeHead;
        ListNode scanner = head;
        
        while(scanner != null && scanner.val < x){
            scanner = scanner.next;
            addingPoint = addingPoint.next;
        }
        
        ListNode relay = scanner;
        
        if(scanner == null)
        return head;
        
        while(relay.next != null){
            if(relay.next.val < x){
            ListNode temp = addingPoint.next;
            addingPoint.next = new ListNode(relay.next.val);
            addingPoint.next.next = temp; 
            addingPoint = addingPoint.next;
            relay.next =relay.next.next;
            }else{
            relay = relay.next;    
            }
        }
        
        return fakeHead.next;
    }
}