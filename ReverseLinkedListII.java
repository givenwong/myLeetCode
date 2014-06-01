public class ReverseLinkedListII {
   public ListNode reverseBetween(ListNode head, int m, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(head==null || head.next == null) return head;
        
        ListNode prev = new ListNode(0);
        prev.next=head;
        head=prev;
        ListNode n1=head;
        int k=m-1;
        while(k>0){
            n1=n1.next;
            k--;
        }
        
        prev=n1;
        n1=n1.next;
        k=n-m;
        while(n1.next!=null && k>0){
            ListNode temp =n1.next;
            n1.next=temp.next;
            temp.next=prev.next;
            prev.next=temp;
            k--;
        }
        return head.next;
    }
}