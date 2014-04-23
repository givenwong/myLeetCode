
public class AddTwoNumbers {
	
	
	
	  public class ListNode {
	      int val;
	      ListNode next;
	     ListNode(int x) {
	         val = x;
	         next = null;
	     }
	  }
	 
	
	
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
     int bitResult =0;
     int carry =0;
     ListNode firstPosition = l1;
     ListNode secondPosition = l2;
     ListNode headOfResult = new ListNode(0);
     ListNode resultPosition = headOfResult;
     
     
      bitResult = (firstPosition.val + secondPosition.val + carry)%10;
      carry = (firstPosition.val + secondPosition.val + carry)/10;
      resultPosition.val = bitResult;
      firstPosition = firstPosition.next;
      secondPosition = secondPosition.next;
     
     while(firstPosition != null && secondPosition != null ){
         
         bitResult = (firstPosition.val + secondPosition.val + carry)%10;
         carry = (firstPosition.val + secondPosition.val + carry)/10;
         ListNode temp = new ListNode(bitResult);
         resultPosition.next = temp;
         resultPosition = resultPosition.next;
         firstPosition = firstPosition.next;
         secondPosition = secondPosition.next;
     }
     
     ListNode notFinishedPos = null;
     
         if (firstPosition == null && secondPosition != null) 
               notFinishedPos = secondPosition;
         else if(firstPosition != null && secondPosition == null)
              notFinishedPos = firstPosition;
       
              
        while(notFinishedPos != null){
                bitResult = (notFinishedPos.val + carry)%10;
         carry = (notFinishedPos.val + carry)/10;
         ListNode temp = new ListNode(bitResult);
         resultPosition.next = temp;
         resultPosition = resultPosition.next;
         notFinishedPos = notFinishedPos.next;
       
        }      
    
    if(carry != 0){
         ListNode temp = new ListNode(carry);
         resultPosition.next = temp;
         resultPosition = resultPosition.next;
    }
            
    return  headOfResult;        
         
}

}
