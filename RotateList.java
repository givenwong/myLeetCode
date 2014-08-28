/*Given a list, rotate the list to the right by k places, where k is non-negative.

For example:
Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.*/
public class RotateList {
	
    public ListNode rotateRight(ListNode head, int n) {
        
        if(head == null)
        return head;
        
        int length =0;
        ListNode scanner = head;
        
        while(scanner != null){
            length++;
            scanner = scanner.next;
        }
        
        int displacement = n%length;
        
        ListNode slow = head;
        ListNode fast = head;
        
        while(displacement>0){
            displacement--;
            fast = fast.next;
        }
        
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        
        fast.next = head;
        head = slow.next;
        slow.next = null;
        
        return head;
    }
}