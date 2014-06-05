
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
     // the result by the linked list is in the reverse order 	
     int bitResult =0;
     int carry =0;
     ListNode firstPosition = l1;
     ListNode secondPosition = l2;
     ListNode headOfResult = new ListNode(0); // the least significant bit result
     ListNode resultPosition = headOfResult;
     // why is the first node a singleton? Need the first node to be the head of the result.
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
