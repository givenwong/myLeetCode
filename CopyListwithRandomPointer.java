
  
  class RandomListNode {
      int label;
      RandomListNode next, random;
      RandomListNode(int x) { this.label = x; }
 };
 
public class CopyListwithRandomPointer  {
    public RandomListNode copyRandomList(RandomListNode head) {
     
     if(head == null)
     return null;
     
     if(head.next == null){
         RandomListNode result = new RandomListNode(head.label);
         result.next = null;
         if(head.random != null)
         result.random = result;
         return result;
     }
     
     
     RandomListNode scanner = head;
     
     while(scanner != null){
         
         RandomListNode temp = new RandomListNode(scanner.label);
         temp.next = scanner.next;
         scanner.next = temp;
         scanner = scanner.next.next;
     }
     
        scanner = head;
        while(scanner != null){
         if(scanner.random != null)
         scanner.next.random = scanner.random.next;
         
         scanner = scanner.next.next;
     }
     
       RandomListNode fakeHead = head.next; 
       RandomListNode scannerOne = head;
       RandomListNode scannerTwo = fakeHead;
        
         while(scannerTwo.next != null){
         RandomListNode temp = scannerTwo.next;
         scannerTwo.next= scannerTwo.next.next;
         scannerOne.next = temp;
         scannerOne = scannerOne.next;
         scannerTwo = scannerTwo.next;
     }
     
     scannerOne.next = null;
     
     return fakeHead;
       
    }
}