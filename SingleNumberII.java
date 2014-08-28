/*Given an array of integers, every element appears three times except for one. 
 * Find that single one*/


// The basic bit operations:
// 1. A[i]&(1<<j): to see if the j th bit (from back) is 1
// 2. result |= (1<<i): result = result | (1<<i)
public class SingleNumberII  {
    public int singleNumber(int[] A) {
       
       // count each bit's frequency	
       int[] bitCount = new int[32];
       
        for(int j =0; j< 32; j++){
          for(int i = 0; i< A.length; i++){
                   bitCount[j] += (A[i]&(1<<j)) == 0?0:1; 
           }
       }
       
       int result = 0;
       for(int i =0; i< 32; i++){
           if(bitCount[i]%3 != 0) // if the condition is true: the singleton has a "1" at bit i
           result |= (1<<i); // why OR? because want to NOT modify all the other bits except for bit i
       }
    
    return result;
    }
}