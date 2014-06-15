// Two ways to reverse a list
// 1. recursion
// 2. iterations: split list into two parts: reversed part and the remaining part and use a probe to process (add the node
// 	  to the front of the already part) and probe moves to the following node in the list... so on so forth


public class ReverseLinkedListII {
	
   public ListNode reverseBetween(ListNode head, int m, int n) {
        
        if(head==null || head.next == null) return head;
        
        ListNode prev = new ListNode(0);
        prev.next=head;
        // the head now points to the dummy
        // why dummy? maybe the whole list, say m=1 need to be reversed
        head=prev;
        
        ListNode n1=head;
        int k=m-1;
        while(k>0){
            n1=n1.next;
            k--;
        }
        // prev's next node is the first node of the already reversed part
        prev=n1;
        
        // n1 is the last node of the already reversed part
        n1=n1.next;
        
        // k is the number of nodes which need to be processed (reversed)
        k=n-m;
        
        // n1.next != null is a condition to prevent n, m of non sense
        while(n1.next!=null && k>0){
        	// here temp is the new node
            ListNode temp =n1.next;
            // delete the new node from the 2nd part
            // now n1.next points to the new new node (the next node of temp)
            // so don't have to explicitly move n1 forward
            // it serves the purpose to probe to the a new node
            n1.next=temp.next;
            
            // put the new node temp at the beginning of the already reversed part 
            temp.next=prev.next;
            // put the new node temp at the beginning of the already reversed part
            prev.next=temp;
            //
            k--;
        }
        return head.next;
    }
}